package trim.api.domains.member.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import trim.api.common.util.EnumMappingUtil;
import trim.api.domains.member.vo.MemberRequest;
import trim.api.domains.member.vo.MemberResponse;
import trim.common.util.EnumConvertUtil;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.SocialType;

@Mapper(componentModel = "spring", uses = EnumMappingUtil.class, builder = @Builder(disableBuilder = false))
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "socialType", qualifiedByName = "stringToSocialType")
    Profile toProfile(MemberRequest memberRequest);

    @Mapping(target = "socialType", source = "profile.socialType")
    @Mapping(target = "email", source = "profile.email")
    @Mapping(target = "memberId", source = "id")
    MemberResponse toMemberResponse(Member member);

}
