package trim.domains.badge.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Table(name = "badge")
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "badge_id")
    private Long id;

    private int level;

    @Column(unique = true)
    private String badgeTitle;

    private int goal;

    @Builder.Default
    private int point = 10;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BadgeContent badgeContent;

}
