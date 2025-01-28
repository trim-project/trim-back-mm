package trim.domains.tag.business.service;


import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.tag.dao.entity.BoardTag;
import trim.domains.tag.dao.entity.Tag;
import trim.domains.tag.dao.repository.BoardTagRepository;
import trim.domains.tag.dao.repository.TagRepository;

@Adaptor
@RequiredArgsConstructor
public class TagDomainServiceImpl implements TagDomainService{

    private final TagRepository tagRepository;
    private final BoardTagRepository boardTagRepository;


    @Override
    public Tag addTagInBoard(Long boardId, String content) {
        Tag tag = Tag.builder()
                .name(content)
                .build();
        tagRepository.save(tag);
        BoardTag boardTag = BoardTag.builder()
                .boardId(boardId)
                .tagId(tag.getId())
                .build();
        boardTagRepository.save(boardTag);
        return tag;
    }
}
