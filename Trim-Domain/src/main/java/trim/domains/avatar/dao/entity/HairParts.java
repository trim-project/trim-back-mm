package trim.domains.avatar.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import trim.domains.avatar.dao.entity.enums.HairColor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HairParts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // hair_parts_id

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HairColor hairColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hair_id", nullable = false)
    private Hair hair;

    @Column(nullable = false)
    private String imageUrl;
}
