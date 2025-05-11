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
@SuperBuilder
@Table(
        name = "cloth_parts",
        uniqueConstraints = {
                @UniqueConstraint(name = "color_cloth", columnNames = {"cloth_color", "cloth_id"})
        }
)
@NoArgsConstructor
@AllArgsConstructor
public class ClothParts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloth_parts_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private ClothColor clothColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cloth_id", nullable = false)
    private Cloth cloth;

    private String imageUrl;
}
