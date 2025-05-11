package trim.api.domains.avatar.mapper.parts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.avatar.vo.response.parts.ClothPartsResponse;
import trim.domains.avatar.dao.entity.parts.ClothParts;

@Mapper(componentModel = "spring")
public interface ClothPartsMapper {

    ClothPartsMapper INSTANCE = Mappers.getMapper(ClothPartsMapper.class);

    @Mapping(source = "cloth.id", target = "clothId")
    @Mapping(source = "cloth.price", target = "price")
    @Mapping(source = "imageUrl", target = "imageUrl")
    ClothPartsResponse toResponse(ClothParts clothParts);
}
