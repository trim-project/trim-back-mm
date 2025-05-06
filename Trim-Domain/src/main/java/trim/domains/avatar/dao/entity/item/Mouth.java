package trim.domains.avatar.dao.entity.item;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import trim.domains.avatar.dao.entity.enums.MouthAvatarNumber;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class Mouth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mouth_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, columnDefinition = "varchar(50)")
    private MouthAvatarNumber avatarNumber;

    @Column(nullable = false)
    @Builder.Default
    private int price = 10;
}
