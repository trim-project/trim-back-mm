package trim.domains.question.business.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.answer.dao.repository.AnswerRepository;
import trim.domains.member.dao.domain.Member;
import trim.domains.question.dao.domain.Question;
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
