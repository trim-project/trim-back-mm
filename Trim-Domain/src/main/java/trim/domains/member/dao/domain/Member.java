package trim.domains.member.dao.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;

@Entity
@Getter
@SuperBuilder
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_email_social", columnNames = {"email", "social_type"})
        }
)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    private Profile profile;

    @Column(nullable = false, unique = true)
    private String nickname;

    // 변경될 수 있음
    private int nicknameChangeChance;

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void countConvertNicknameChance() {
        this.nicknameChangeChance--;
    }


}