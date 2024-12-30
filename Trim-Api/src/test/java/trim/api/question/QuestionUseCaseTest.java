package trim.api.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import trim.TrimApiServiceApplication;
import trim.api.question.service.*;
import trim.domains.comment.adaptor.QuestionCommentAdaptor;
import trim.domains.comment.domain.QuestionComment;
import trim.domains.member.domain.Member;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.request.EditQuestionRequest;
import trim.domains.question.dto.response.FindQuestionResponse;
import trim.domains.question.dto.response.QuestionResponse;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = TrimApiServiceApplication.class)
@ActiveProfiles("test")
public class QuestionUseCaseTest {
    @Mock
    private QuestionAdaptor questionAdaptor;

    @Mock
    private QuestionCommentAdaptor questionCommentAdaptor;

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

    @Mock
    private Member testMember;

    @Mock
    private Question testQuestion;

    @Mock
    private QuestionComment questionComment;

    private CreateQuestionRequest createRequest;
    private EditQuestionRequest editRequest;

    @BeforeEach
    void setUp() {
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
        //given
        when(createQuestionUseCase.execute(any(Member.class), any(CreateQuestionRequest.class)))
                .thenAnswer(invocation -> {
                    Question createdQuestion = Question.builder()
                            .id(1L)
                            .build();
                    return createdQuestion.getId();
                });

        //when
        Long resultId = createQuestionUseCase.execute(testMember, createRequest);

        //then
        assertThat(resultId).isEqualTo(1L);
        verify(createQuestionUseCase, times(1)).execute(testMember, createRequest);
    }

    @Test
    void findQuestion_Success() throws Exception {
        //given
        Long questionId = 1L;

        Question question = Question.builder()
                .id(questionId)
                .title("title")
                .content("content")
                .build();

        when(questionAdaptor.queryById(questionId)).thenReturn(question);

        // when: execute 메서드 호출
        QuestionResponse response = findQuestionUseCase.execute(questionId);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo(question.getTitle());
        assertThat(response.getContent()).isEqualTo(question.getContent());

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

    }

    @Test
    void updateQuestion_Success() throws Exception {

    }

    @Test
    void deleteQuestion_Success() throws Exception {

    }
}