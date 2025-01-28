package trim.domains.tag.business.service;

import trim.domains.board.dao.domain.Board;
import trim.domains.tag.dao.entity.Tag;

public interface TagDomainService {

    Tag addTagInBoard(Long boardId, String content);
}
