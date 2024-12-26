package trim.domains.question.service;

import trim.domains.member.domain.Member;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.request.EditQuestionRequest;

public interface QuestionDomainService {

    Long writeQuestion(Member member, CreateQuestionRequest request);

    void editQuestion(Member member, Long questionId, EditQuestionRequest request);

    void removeQuestion(Member member, Long questionId);
}
