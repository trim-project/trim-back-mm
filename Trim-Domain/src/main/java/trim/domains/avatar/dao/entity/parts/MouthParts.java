package trim.domains.avatar.dao.entity.parts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.avatar.dao.entity.enums.MouthForURL;
import trim.domains.avatar.dao.entity.item.Mouth;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MouthParts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mouth_parts_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mouth_id", nullable = false)
    private Mouth mouth;

    private MouthForURL imageUrl;
}
