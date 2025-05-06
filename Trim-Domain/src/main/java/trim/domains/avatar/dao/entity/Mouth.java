package trim.domains.avatar.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import trim.domains.avatar.dao.entity.enums.MouthAvatarNumber;

@Entity
@Getter
@NoArgsConstructor
public class Mouth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MouthAvatarNumber avatarNumber;

    @Column(nullable = false)
    private int price;
}
