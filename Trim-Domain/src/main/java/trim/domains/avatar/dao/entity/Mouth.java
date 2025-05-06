package trim.domains.avatar.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import trim.domains.avatar.dao.entity.enums.MouthAvatarNumber;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Mouth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private MouthAvatarNumber avatarNumber;

    @Column(nullable = false)
    @Builder.Default
    private int price = 10;
}
