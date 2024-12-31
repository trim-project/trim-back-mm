package trim.api.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
import trim.domains.question.service.QuestionDomainService;

import java.util.Arrays;
import java.util.Collections;
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
    @Mock
    private QuestionDomainService questionDomainService;

    @InjectMocks
    private CreateQuestionUseCase createQuestionUseCase;
    @InjectMocks
    private FindQuestionUseCase findQuestionUseCase;
    @InjectMocks
    private FindAllQuestionUseCase findAllQuestionUseCase;

    @Mock
    private Member testMember;

    private CreateQuestionRequest createRequest;

    @BeforeEach
    void setUp() {
        testMember = Member.builder()
                .id(1L)
                .nickname("nickname")
                .nicknameChangeChance(1).build();

        createRequest = CreateQuestionRequest.builder()
                .title("Test Title")
                .content("Test Content")
                .build();

    }

    @Test
    @DisplayName("질문 생성을 테스트합니다")
    void createQuestion_Success() throws Exception {
        //given
        Long newQuestionId = 1L;
        when(questionDomainService.writeQuestion(testMember, createRequest))
                .thenReturn(newQuestionId);

        //when
        Long resultId = createQuestionUseCase.execute(testMember, createRequest);

        //then
        assertThat(resultId).isEqualTo(newQuestionId);
        verify(questionDomainService).writeQuestion(testMember, createRequest);
    }

    @Test
    @DisplayName("질문 단일 조회를 테스트합니다")
    void findQuestion_Success() throws Exception {
        //given
        Long questionId = 1L;

        Question question = Question.builder()
                .id(questionId)
                .title("title")
                .content("content")
                .writer(testMember)
                .build();

        when(questionAdaptor.queryById(questionId)).thenReturn(question);
        when(questionCommentAdaptor.queryAllByQuestionId(questionId)).thenReturn(Collections.emptyList());



        // when: execute 메서드 호출
        QuestionResponse response = findQuestionUseCase.execute(questionId);


        // then
        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo(question.getTitle());
        assertThat(response.getContent()).isEqualTo(question.getContent());

        verify(questionAdaptor).queryById(questionId);
        verify(questionCommentAdaptor).queryAllByQuestionId(questionId);
    }

    @Test
    @DisplayName("질문 전체 조회(리스트)를 테스트합니다")
    void findAllQuestions_Success() throws Exception {
        //given
        List<Question> questions = Arrays.asList(
                Question.builder()
                        .title("Title1")
                        .writer(testMember)
                        .build(),
                Question.builder()
                        .title("Title2")
                        .writer(testMember)
                        .build()
                );
        when(questionAdaptor.queryAll()).thenReturn(questions);

        //when
        List<FindQuestionResponse> responses = findAllQuestionUseCase.execute();

        //then
        assertThat(responses.get(0).getTitle()).isEqualTo(questions.get(0).getTitle());
        assertThat(responses.get(1).getTitle()).isEqualTo(questions.get(1).getTitle());
        verify(questionAdaptor).queryAll();
    }

}