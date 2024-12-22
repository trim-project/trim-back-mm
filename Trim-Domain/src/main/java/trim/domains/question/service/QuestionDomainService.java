package trim.domains.question.service;

import trim.domains.member.domain.Member;
import trim.domains.question.dto.QuestionDto;

public interface QuestionDomainService {

    Long writeQuestion(Member member, QuestionDto request);

    void editQuestion(Member member, Long questionId, QuestionDto request);

    void removeQuestion(Member member, Long questionId);
}
