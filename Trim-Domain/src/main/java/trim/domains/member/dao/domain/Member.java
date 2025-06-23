package trim.domains.member.dao.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.avatar.dao.entity.enums.*;
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
    @Builder.Default
    private Avatar avatar = Avatar.builder()
            .backgroundColor(BackgroundColor.LAVENDER)
            .clothForURL(ClothForURL.BLACK_R1.getKey())
            .mouthForURL(MouthForURL.MOUTH_1.getKey())
            .hairForURL(HairForURL.HAIR_16_BLUE.getKey())
            .eyesForURL(EyesForURL.EYES_1.getKey())
            .build();

    @Column(nullable = false, unique = true)
    private String nickname;

    private String name;

    private String major;

    private String university;

    private String description;

    @Builder.Default
    private int point = 300;

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

    public void addPoint(int point) {
        this.point += point;
    }
}