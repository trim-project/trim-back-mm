package trim.domains.question.business.validate;

import trim.domains.member.dao.domain.Member;
import trim.domains.question.dao.domain.Question;

public interface QuestionValidate {

    void checkIsWriter(Member member, Question question);

    void canDelete(Member member, Question question);

}
