package trim.api.domains.avatar.mapper.parts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.avatar.vo.response.parts.HairPartsResponse;
import trim.domains.avatar.dao.entity.parts.HairParts;

@Mapper(componentModel = "spring")
public interface HairPartsMapper {

    HairPartsMapper INSTANCE = Mappers.getMapper(HairPartsMapper.class);

    @Mapping(source = "hair.id", target = "hairId")
    @Mapping(source = "hair.price", target = "price")
    @Mapping(source = "imageUrl", target = "imageUrl")
    HairPartsResponse toResponse(HairParts hairParts);
}

