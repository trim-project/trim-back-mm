package trim.domains.comment.adaptor;


import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.common.exception.ErrorStatus;
import trim.domains.comment.domain.QuestionComment;
import trim.domains.comment.exception.QuestionCommentHandler;
import trim.domains.comment.repository.QuestionCommentRepository;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class QuestionCommentAdaptorImpl implements QuestionCommentAdaptor{

    private final QuestionCommentRepository questionCommentRepository;

    @Override
    public QuestionComment queryById(Long questionCommentId) {
        return questionCommentRepository.findById(questionCommentId)
                .orElseThrow(() -> QuestionCommentHandler.NOT_FOUND);
    }

    @Override
    public List<QuestionComment> queryAllByQuestionId(Long questionId) {
        return questionCommentRepository.findAllByQuestionId(questionId);
    }

}
