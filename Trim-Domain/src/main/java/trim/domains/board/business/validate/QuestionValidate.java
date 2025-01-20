package trim.domains.board.business.validate;

import trim.domains.board.dao.domain.Question;
import trim.domains.member.dao.domain.Member;

public interface QuestionValidate {

    void checkIsWriter(Member member, Question question);

    void canDelete(Member member, Question question);

}
