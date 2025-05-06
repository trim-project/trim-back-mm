package trim.domains.avatar.dao.entity.stored;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.avatar.dao.entity.enums.BackgroundColor;
import trim.domains.avatar.dao.entity.parts.ClothParts;
import trim.domains.avatar.dao.entity.parts.EyesParts;
import trim.domains.avatar.dao.entity.parts.HairParts;
import trim.domains.avatar.dao.entity.parts.MouthParts;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class StoredAvatar extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stored_avatar_id")
    private Long id;

    @Column(nullable = false)
    private boolean isSelected;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, columnDefinition = "varchar(50)")
    private BackgroundColor backgroundColorNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hair_parts_id")
    private HairParts hairParts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eyes_parts_id")
    private EyesParts eyesParts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mouth_parts_id")
    private MouthParts mouthParts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cloth_parts_id")
    private ClothParts clothParts;
}

