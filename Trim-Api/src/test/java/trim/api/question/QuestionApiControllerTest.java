package trim.api.question;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import trim.api.question.controller.QuestionApiController;
import trim.api.question.service.*;
import trim.domains.member.domain.Member;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.request.EditQuestionRequest;
import trim.domains.question.dto.response.FindQuestionResponse;
import trim.domains.question.dto.response.QuestionResponse;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = {QuestionApiController.class,
                ObjectMapper.class,
                WebMvcAutoConfiguration.class},
        properties = "spring.main.allow-multiple-contexts=true"
)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class QuestionApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CreateQuestionUseCase createQuestionUseCase;
    @MockitoBean
    private EditQuestionUseCase editQuestionUseCase;
    @MockitoBean
    private FindQuestionUseCase findQuestionUseCase;
    @MockitoBean
    private FindAllQuestionUseCase findAllQuestionUseCase;
    @MockitoBean
    private DeleteQuestionUseCase deleteQuestionUseCase;

    private Member testMember;
    private CreateQuestionRequest createRequest;
    private EditQuestionRequest editRequest;

    @BeforeEach
    void setUp() {
        testMember = Member.builder()
                .id(1L)
                .nicknameChangeChance(1)
                .build();

        createRequest = CreateQuestionRequest.builder()
                .title("Test Title")
                .content("Test Content")
                .build();
        editRequest = EditQuestionRequest
                .builder()
                .title("Updated Title")
                .content("Updated Content")
                .build();
    }

    @Test
    void createQuestion_Success() throws Exception {
        when(createQuestionUseCase.execute(any(Member.class), any(CreateQuestionRequest.class)))
                .thenReturn(1L);
//        when(createQuestionUseCase.execute(testMember, createRequest))
//                .thenReturn(1L);

        mockMvc.perform(post("/api/question/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createRequest))
                        .sessionAttr("writer", testMember))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void findQuestion_Success() throws Exception {
        QuestionResponse response = QuestionResponse.builder()
                .title("Test Title")
                .content("Test Content")
                .build();

        when(findQuestionUseCase.execute(1L)).thenReturn(response);

        mockMvc.perform(get("/api/question/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    void findAllQuestions_Success() throws Exception {
        List<FindQuestionResponse> responses = Arrays.asList(
                FindQuestionResponse.builder()
                        .title("Title1")
                        .nickname("Nickname1")
                        .build(),
                FindQuestionResponse.builder()
                        .title("Title2")
                        .nickname("Nickname2")
                        .build()
                );
        when(findAllQuestionUseCase.execute()).thenReturn(responses);

        mockMvc.perform(get("/api/question/"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(responses)));
    }

    @Test
    void updateQuestion_Success() throws Exception {
        mockMvc.perform(post("/api/question/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(editRequest)))
                .andExpect(status().isOk());

        verify(editQuestionUseCase).execute(any(Member.class), eq(1L), any(EditQuestionRequest.class));
    }

    @Test
    void deleteQuestion_Success() throws Exception {

    }
}