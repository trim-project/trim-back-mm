package trim.domains.question.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;
import trim.domains.question.repository.QuestionRepository;

@DomainValidator
@RequiredArgsConstructor
public class QuestionValidateImpl implements QuestionValidate{

    @Override
    public void checkIsWriter(Member member, Question question) {
        if (!question.getWriter().equals(member)) {
            throw new RuntimeException("is not writer");
        }
    }
}
