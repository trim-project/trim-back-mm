package trim.domains.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;

import java.util.ArrayList;

@Entity
@Getter
@SuperBuilder
@Table(name = "member", indexes = {
        @Index(name = "idx_username", columnList = "username"),
        @Index(name = "idx_nickname", columnList = "nickname")
})
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String nickname;

    private String email;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    // 변경될 수 있음
    private int nicknameChangeChance;

//    @OneToMany(mappedBy = "writer")
//    private List<Question> questionList = new ArrayList<>();

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority(this.role.getKey()));
//    }

//    @Override
//    public String getPassword() {
//        return null;        //해당 항목 없음
//    }


}