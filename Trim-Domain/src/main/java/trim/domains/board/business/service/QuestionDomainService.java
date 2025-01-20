package trim.domains.board.business.service;

import trim.domains.board.dao.domain.Question;
import trim.domains.member.dao.domain.Member;
import trim.domains.board.dto.QuestionDto;


public interface QuestionDomainService {

    Long writeQuestion(Member member, QuestionDto dto);

    void editQuestion(Question question, QuestionDto dto);

    void deleteQuestion(Member member, Long questionId);
}
