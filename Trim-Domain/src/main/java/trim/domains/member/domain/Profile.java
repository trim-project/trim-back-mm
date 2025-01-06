package trim.domains.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Column(nullable = false, unique = true)
    private String username;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_type", length = 50)
    private SocialType socialType;
}
