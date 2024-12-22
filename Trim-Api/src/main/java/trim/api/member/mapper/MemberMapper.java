package trim.api.member.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.member.vo.MemberRequest;
import trim.domains.member.domain.Profile;
import trim.domains.member.domain.Role;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Profile toProfile(MemberRequest memberRequest);

}
