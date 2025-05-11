package trim.api.domains.avatar.mapper.parts;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.avatar.vo.response.parts.EyesPartsResponse;
import trim.domains.avatar.dao.entity.parts.EyesParts;

@Mapper(componentModel = "spring")
public interface EyesPartsMapper {

    EyesPartsMapper INSTANCE = Mappers.getMapper(EyesPartsMapper.class);

    @Mapping(source = "eyes.id", target = "eyesId")
    @Mapping(source = "eyes.price", target = "price")
    @Mapping(source = "imageUrl", target = "imageUrl")
    EyesPartsResponse toResponse(EyesParts eyesParts);

}
