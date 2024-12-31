package trim.api.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.member.service.RegisterMemberUseCase;
import trim.api.member.vo.MemberRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @PostMapping
    public Long registerServerTestMember(@RequestBody MemberRequest memberRequest) {
        return registerMemberUseCase.execute(memberRequest);
    }
}
