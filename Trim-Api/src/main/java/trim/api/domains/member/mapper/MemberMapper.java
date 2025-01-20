package trim.api.domains.member.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import trim.api.domains.member.vo.MemberRequest;
import trim.common.util.EnumConvertUtil;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.SocialType;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "socialType", qualifiedByName = "stringToSocialType")
    Profile toProfile(MemberRequest memberRequest);

    @Named("stringToSocialType")
    default SocialType stringToSocialType(String socialType) {
        return EnumConvertUtil.convert(SocialType.class, socialType);
    }

}
