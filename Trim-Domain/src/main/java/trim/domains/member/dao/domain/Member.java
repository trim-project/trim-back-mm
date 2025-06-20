package trim.domains.member.dao.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.avatar.dao.entity.enums.BackgroundColor;
import trim.domains.avatar.dao.entity.parts.MouthParts;
import trim.domains.member.dto.MemberProfileDto;

@Entity
@Getter
@SuperBuilder
@Table(
        name = "member",
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

    @Embedded
    private Avatar avatar;

    @Column(nullable = false, unique = true)
    private String nickname;

    private String name;

    private String major;

    private String university;

    private String description;

    @Builder.Default
    private int point = 0;

    public void updatePoint(int point) {
        this.point += point;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void usePoint(int point) {this.point -= point;}

    public void updateProfileInfo(MemberProfileDto dto) {
        this.nickname = dto.getNickname();
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.major = dto.getMajor();
        this.university = dto.getUniversity();
    }

    public void changeAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
}