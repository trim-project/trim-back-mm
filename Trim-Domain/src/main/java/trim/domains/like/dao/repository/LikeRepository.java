package trim.domains.like.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.like.dao.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Long countByBoardId(Long boardId);

    boolean existsByBoardIdAndMemberId(Long boardId, Long memberId);

    void deleteAllByBoardId(Long boardId);
}
