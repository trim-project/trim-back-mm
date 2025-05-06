package trim.domains.avatar.dao.entity.parts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.avatar.dao.entity.enums.ClothColor;
import trim.domains.avatar.dao.entity.item.Cloth;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ClothParts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloth_parts_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, columnDefinition = "varchar(50)")
    private ClothColor clothColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cloth_id")
    private Cloth cloth;

    private String imageUrl;
}
