package trim.domains.comment.business.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.comment.exception.CommentHandler;
import trim.domains.member.dao.domain.Member;

import java.util.Objects;

@DomainValidator
@RequiredArgsConstructor
public class QuestionCommentValidatorImpl implements QuestionCommentValidator{

    @Override
    public void checkCanDelete(Member writer, Comment comment) {
        if(isNotWriter(writer, comment)){
            throw CommentHandler.ONLY_WRITER;
        }
    }

    private boolean isNotWriter(Member writer, Comment comment){
        return !Objects.equals(writer, comment);
    }

}
