package trim.domains.question.service;

import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;
import trim.domains.question.dto.QuestionDto;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.request.EditQuestionRequest;

public interface QuestionDomainService {

    Long writeQuestion(Member member, QuestionDto dto);

    void editQuestion(Question question, QuestionDto dto);

    void deleteQuestion(Member member, Long questionId);
}
