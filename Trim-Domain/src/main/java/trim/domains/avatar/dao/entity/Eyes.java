package trim.domains.avatar.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import trim.domains.avatar.dao.entity.enums.EyesAvatarNumber;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Eyes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private EyesAvatarNumber avatarNumber;

    @Column(nullable = false)
    @Builder.Default
    private int price = 10;
}

