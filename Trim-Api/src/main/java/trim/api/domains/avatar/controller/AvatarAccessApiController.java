package trim.api.domains.avatar.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "[아바타]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/avatar)
public class AvatarAccessApiController {

    private final AvatarAdaptor avatarAdaptor;

    public List<AvatarResponse> execute() {
        List<Avatar> badges = badgeAdaptor.queryAllBadge();
        return badges.stream()
                .map(BadgeMapper.INSTANCE::toResponseBadge)
                .toList();
    }
}
