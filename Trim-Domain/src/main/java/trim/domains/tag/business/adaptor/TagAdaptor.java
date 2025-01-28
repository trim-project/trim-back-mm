package trim.domains.tag.business.adaptor;

import trim.domains.tag.dao.entity.Tag;

import java.util.List;

public interface TagAdaptor {

    List<Tag> queryByBoardId(Long boardId);

    List<String> queryNamesByBoardId(Long boardId);
}
