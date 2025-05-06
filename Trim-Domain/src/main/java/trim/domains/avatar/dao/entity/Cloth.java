package trim.domains.avatar.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import trim.domains.avatar.dao.entity.enums.ClothAvatarNumber;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private ClothAvatarNumber avatarNumber;

    @Column(nullable = false)
    @Builder.Default
    private int price = 10;

}

