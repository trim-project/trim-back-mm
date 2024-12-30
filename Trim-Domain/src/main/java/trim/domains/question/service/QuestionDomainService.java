package trim.domains.question.service;

import trim.domains.member.domain.Member;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.request.EditQuestionRequest;

public interface QuestionDomainService {

    Long writeQuestion(Member member, CreateQuestionRequest dto);

    void editQuestion(Member member, Long questionId, EditQuestionRequest dto);

    void deleteQuestion(Member member, Long questionId);
}
