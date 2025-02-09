package trim.domains.like.business.adaptor;

public interface LikeAdaptor {

    Long queryCountByBoard(Long boardId);

    boolean queryExist(Long boardId, Long memberId);
}
