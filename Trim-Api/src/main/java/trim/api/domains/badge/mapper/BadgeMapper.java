package trim.api.domains.badge.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.badge.vo.response.BadgeResponse;
import trim.domains.badge.dao.entity.Badge;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface BadgeMapper {

    BadgeMapper INSTANCE = Mappers.getMapper(BadgeMapper.class);

    @Mapping(target = "badgeId", source = "badge.id")
    BadgeResponse toResponseBadge(Badge badge);
}
