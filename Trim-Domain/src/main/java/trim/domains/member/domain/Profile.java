package trim.domains.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

    @Column(nullable = false, unique = true)
    private String username;

    private String email;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;
}
