package trim.domains.tag.business.service;

import trim.domains.board.dao.domain.Board;
import trim.domains.tag.dao.entity.Tag;

import java.util.List;

public interface TagDomainService {

    List<Tag> addTagsInBoard(Long boardId, List<String> tags);
}
