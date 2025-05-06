package trim.domains.avatar.dao.entity.item;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.avatar.dao.entity.enums.ClothAvatarNumber;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class Cloth extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloth_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, columnDefinition = "varchar(50)")
    private ClothAvatarNumber avatarNumber;

    @Column(nullable = false)
    @Builder.Default
    private int price = 10;

}

