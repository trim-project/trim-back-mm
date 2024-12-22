package trim.api.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.api.member.service.RegisterMemberUseCase;
import trim.api.member.vo.MemberRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @GetMapping
    public Long registerServerTestMember(@RequestBody MemberRequest memberRequest) {
        return registerMemberUseCase.execute(memberRequest);
    }
}
