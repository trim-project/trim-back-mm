package trim.domains.avatar.dao.entity.parts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.avatar.dao.entity.enums.EyesForURL;
import trim.domains.avatar.dao.entity.item.Eyes;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EyesParts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eyes_parts_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eyes_id", nullable = false)
    private Eyes eyes;

    @Enumerated(EnumType.STRING)
    private EyesForURL imageUrl;
}

