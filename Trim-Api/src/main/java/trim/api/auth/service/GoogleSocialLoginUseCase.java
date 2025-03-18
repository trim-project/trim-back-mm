package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.common.security.dto.JwtToken;
import trim.api.common.security.service.TokenService;
import trim.common.annotation.UseCase;
import trim.common.util.EnumConvertUtil;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.SocialType;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoogleSocialLoginUseCase {

    private final MemberAdaptor memberAdaptor;
    private final TokenService tokenService;

    public JwtToken execute(String email, String socialType) {
        Member member = memberAdaptor
                .queryMemberByEmailAndProvider(email, EnumConvertUtil.convert(SocialType.class, socialType));
        return tokenService.login(member.getProfile().getUsername());
    }
}
