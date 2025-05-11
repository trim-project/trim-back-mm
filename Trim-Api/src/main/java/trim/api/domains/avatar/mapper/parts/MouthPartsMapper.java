package trim.api.domains.avatar.mapper.parts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.avatar.vo.response.parts.MouthPartsResponse;
import trim.domains.avatar.dao.entity.parts.MouthParts;

@Mapper(componentModel = "spring")
public interface MouthPartsMapper {
    MouthPartsMapper INSTANCE = Mappers.getMapper(MouthPartsMapper.class);

    @Mapping(source = "mouth.id", target = "mouthId")
    @Mapping(source = "mouth.price", target = "price")
    @Mapping(source = "imageUrl", target = "imageUrl")
    MouthPartsResponse toResponse(MouthParts mouthParts);
}
