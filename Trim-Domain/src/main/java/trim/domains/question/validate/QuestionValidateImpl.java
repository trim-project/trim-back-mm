package trim.domains.question.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.common.exception.ErrorStatus;
import trim.domains.answer.repository.AnswerRepository;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;
import trim.domains.question.exception.QuestionHandler;

@DomainValidator
@RequiredArgsConstructor
public class QuestionValidateImpl implements QuestionValidate{

    private final AnswerRepository answerRepository;

    @Override
    public void canDelete(Member member, Question question){
        checkIsWriter(member, question);
        checkHaveNotAnswer(question);
    }

    private void checkHaveNotAnswer(Question question) {
        if(answerRepository.existsByQuestionId(question.getId())){
            throw QuestionHandler.HAVE_ANY_ANSWER;
        }
    }

    @Override
    public void checkIsWriter(Member member, Question question) {
        if (!question.getWriter().equals(member)) {
            throw QuestionHandler.ONLY_WRITER;
        }
    }
}
