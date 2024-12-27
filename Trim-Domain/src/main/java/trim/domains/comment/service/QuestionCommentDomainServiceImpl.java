package trim.domains.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.DomainService;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;
import trim.domains.question.repository.QuestionRepository;
import trim.domains.comment.domain.QuestionComment;
import trim.domains.comment.dto.request.CreateQuestionCommentRequest;
import trim.domains.comment.repository.QuestionCommentRepository;

@DomainService
@Transactional
@RequiredArgsConstructor
public class QuestionCommentDomainServiceImpl implements QuestionCommentDomainService {

    private final QuestionCommentRepository questionCommentRepository;

    @Override
    public Long createQuestionComment(Member writer, Question question, CreateQuestionCommentRequest dto) {
        QuestionComment questionComment = dto.from(writer, question);
        return questionCommentRepository.save(questionComment).getId();
    }
}
