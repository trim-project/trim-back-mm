package trim.domains.comment.business.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.comment.dao.domain.QuestionComment;
import trim.domains.comment.exception.QuestionCommentHandler;
import trim.domains.member.dao.domain.Member;

import java.util.Objects;

@DomainValidator
@RequiredArgsConstructor
public class QuestionCommentValidatorImpl implements QuestionCommentValidator{

    @Override
    public void checkCanDelete(Member writer, QuestionComment questionComment) {
        if(isNotWriter(writer, questionComment)){
            throw QuestionCommentHandler.ONLY_WRITER;
        }
    }

    private boolean isNotWriter(Member writer, QuestionComment questionComment){
        return !Objects.equals(writer, questionComment);
    }

}
