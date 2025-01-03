package trim.domains.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.DomainService;
import trim.domains.comment.validate.QuestionCommentValidator;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;
import trim.domains.comment.domain.QuestionComment;
import trim.domains.comment.repository.QuestionCommentRepository;

@DomainService
@Transactional
@RequiredArgsConstructor
public class QuestionCommentDomainServiceImpl implements QuestionCommentDomainService {

    private final QuestionCommentRepository questionCommentRepository;

    @Override
    public Long createQuestionComment(Member writer, Question question, String content) {
        QuestionComment questionComment = QuestionComment.builder()
                .question(question)
                .writer(writer)
                .content(content)
                .build();
        return questionCommentRepository.save(questionComment).getId();
    }

    @Override
    public void deleteQuestionComment(Member writer, QuestionComment questionComment) {
        questionCommentRepository.delete(questionComment);
    }
}
