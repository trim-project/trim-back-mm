package trim.domains.comment.business.service;

import trim.domains.comment.dao.domain.QuestionComment;
import trim.domains.member.dao.domain.Member;
import trim.domains.question.dao.domain.Question;


public interface QuestionCommentDomainService {
    Long createQuestionComment(Member writer, Question question, String content);

    void deleteQuestionComment(Member writer, QuestionComment questionComment);

}
