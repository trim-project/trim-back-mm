package trim.domains.board.business.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.board.dao.domain.Board;
import trim.domains.board.dao.domain.BoardType;
import trim.domains.board.dao.domain.Question;
import trim.domains.board.dao.repository.AnswerRepository;
import trim.domains.board.exception.BoardHandler;
import trim.domains.member.dao.domain.Member;

@DomainValidator
@RequiredArgsConstructor
public class BoardValidateImpl implements BoardValidate {

    private final AnswerRepository answerRepository;

    @Override
    public void canDelete(Member member, Board board){
        checkIsWriter(member, board);
    }

    @Override
    public void checkBoardType(Board board, BoardType boardType) {
        if (!board.getBoardType().equals(boardType)) {
            throw BoardHandler.TYPE_IS_NOT_MATCH;
        }
    }

    private void checkHaveNotAnswer(Question question) {
        if(answerRepository.existsByQuestionId(question.getId())){
            throw BoardHandler.HAVE_ANY_ANSWER;
        }
    }

    @Override
    public void checkIsWriter(Member member, Board board) {
        if (!board.getWriter().equals(member)) {
            throw BoardHandler.ONLY_WRITER;
        }
    }
}
