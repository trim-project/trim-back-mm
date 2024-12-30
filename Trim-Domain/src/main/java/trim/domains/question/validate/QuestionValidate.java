package trim.domains.question.validate;

import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;

public interface QuestionValidate {

    void checkIsWriter(Member member, Question question);

    void canDelete(Member member, Question question);

}
