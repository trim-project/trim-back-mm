package trim.domains.avatar.dao.entity.parts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.avatar.dao.entity.item.Hair;

@Entity
@Getter
@SuperBuilder
@Table(
        name = "hair_parts",
        uniqueConstraints = {
                @UniqueConstraint(name = "color_hair", columnNames = {"hair_color", "hair_id"})
        }
)
@NoArgsConstructor
@AllArgsConstructor
public class HairParts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hair_parts_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private HairColor hairColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hair_id", nullable = false)
    private Hair hair;

    @Column(nullable = false)
    private String imageUrl;
}
