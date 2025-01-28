package trim.domains.tag.business.service;


import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.tag.dao.entity.Tag;
import trim.domains.tag.dao.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Adaptor
@RequiredArgsConstructor
public class TagDomainServiceImpl implements TagDomainService{

    private final TagRepository tagRepository;

    @Override
    public List<Tag> addTagsInBoard(Long boardId, List<String> tags) {
        List<Tag> tagList = new ArrayList<>();
        tagRepository.saveAll(tags.stream().map(tag -> Tag.builder()
                .boardId(boardId)
                .name(tag)
                .build()).toList());
        return tagList;
    }
}
