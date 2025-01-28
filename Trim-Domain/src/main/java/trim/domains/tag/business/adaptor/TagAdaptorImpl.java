package trim.domains.tag.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.tag.dao.entity.Tag;
import trim.domains.tag.dao.repository.TagRepository;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class TagAdaptorImpl implements TagAdaptor{

    private final TagRepository tagRepository;

    @Override
    public List<Tag> queryByBoardId(Long boardId) {
        return tagRepository.findByBoardId(boardId);
    }

    @Override
    public List<String> queryNamesByBoardId(Long boardId) {
        return tagRepository.findNamesByBoardId(boardId);
    }
}
