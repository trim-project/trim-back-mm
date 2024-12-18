package trim.domains.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trim.domains.member.adaptor.MemberAdaptor;
import trim.domains.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberDomainServiceImpl implements MemberDomainService{

    private final MemberRepository memberRepository;
    private final MemberAdaptor memberAdaptor;
}
