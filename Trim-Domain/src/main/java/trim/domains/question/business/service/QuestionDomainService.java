package trim.domains.question.business.service;

import trim.domains.member.dao.domain.Member;
import trim.domains.question.dao.domain.Question;
import trim.domains.question.dto.QuestionDto;


public interface QuestionDomainService {

    Long writeQuestion(Member member, QuestionDto dto);

    void editQuestion(Question question, QuestionDto dto);

    void deleteQuestion(Member member, Long questionId);
}
