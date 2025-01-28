package trim.domains.tag.business.service;


import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.tag.dao.entity.BoardTag;
import trim.domains.tag.dao.entity.Tag;
import trim.domains.tag.dao.repository.BoardTagRepository;
import trim.domains.tag.dao.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Adaptor
@RequiredArgsConstructor
public class TagDomainServiceImpl implements TagDomainService{

    private final TagRepository tagRepository;
    private final BoardTagRepository boardTagRepository;


    @Override
    public List<Tag> addTagInBoard(Long boardId, List<String> tags) {
        List<Tag> tagList = tags.stream().map(Tag::of).toList();
        tagRepository.saveAll(tagList);
        List<BoardTag> boardTagList = new ArrayList<>();
        tagList.forEach(tag -> boardTagList.add(BoardTag.builder()
                        .tagId(tag.getId())
                        .boardId(boardId)
                        .build())
                );
        boardTagRepository.saveAll(boardTagList);
        return tagList;
    }
}
