package trim.domains.comment.service;

import trim.domains.member.domain.Member;
import trim.domains.comment.dto.request.CreateQuestionCommentRequest;
import trim.domains.question.domain.Question;


public interface QuestionCommentDomainService {
    Long createQuestionComment(Member writer, Question question, CreateQuestionCommentRequest dto);

}
