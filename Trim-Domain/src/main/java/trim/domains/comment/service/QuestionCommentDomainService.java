package trim.domains.comment.service;

import trim.domains.comment.domain.QuestionComment;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;


public interface QuestionCommentDomainService {
    Long createQuestionComment(Member writer, Question question, String content);

    void deleteQuestionComment(Member writer, QuestionComment questionComment);

}
