package trim.domains.avatar.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MouthParts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // mouth_parts_id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mouth_id", nullable = false)
    private Mouth mouth;

    private String imageUrl;
}
