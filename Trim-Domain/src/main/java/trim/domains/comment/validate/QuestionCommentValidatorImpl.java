package trim.domains.comment.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.common.exception.ErrorStatus;
import trim.common.exception.QuestionCommentHandler;
import trim.domains.comment.domain.QuestionComment;
import trim.domains.comment.repository.QuestionCommentRepository;
import trim.domains.member.domain.Member;

import java.util.Objects;

@DomainValidator
@RequiredArgsConstructor
public class QuestionCommentValidatorImpl implements QuestionCommentValidator{

    @Override
    public void checkCanDelete(Member writer, QuestionComment questionComment) {
        if(isNotWriter(writer, questionComment)){
            throw new QuestionCommentHandler(ErrorStatus.QUESTION_COMMENT_COULD_BE_TOUCHED_BY_ONLY_WRITER);
        }
    }

    private boolean isNotWriter(Member writer, QuestionComment questionComment){
        return !Objects.equals(writer, questionComment);
    }

}
