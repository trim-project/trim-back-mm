package trim.domains.avatar.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import trim.domains.avatar.dao.entity.enums.BackgroundColor;
import trim.domains.avatar.dao.entity.enums.ClothColor;
import trim.domains.avatar.dao.entity.enums.HairColor;

@Entity
@Getter
@NoArgsConstructor
public class StoredAvatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean isSelected;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BackgroundColor backgroundColorNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hair_parts_id", nullable = false)
    private HairParts hairParts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eyes_parts_id", nullable = false)
    private EyesParts eyesParts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mouth_parts_id", nullable = false)
    private MouthParts mouthParts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cloth_parts_id", nullable = false)
    private ClothParts clothParts;
}

