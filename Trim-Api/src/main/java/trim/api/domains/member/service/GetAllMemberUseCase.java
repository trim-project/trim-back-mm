package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.MemberResponse;
import trim.common.annotation.UseCase;
import trim.domains.member.business.adaptor.MemberAdaptor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllMemberUseCase {

    private final MemberAdaptor memberAdaptor;

    public List<MemberResponse> execute() {
        return memberAdaptor.queryAllMember()
                .stream().map(MemberMapper.INSTANCE::toMemberResponse)
                .collect(Collectors.toList());
    }
}
