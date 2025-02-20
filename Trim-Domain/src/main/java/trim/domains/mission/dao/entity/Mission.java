package trim.domains.mission.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.exception.MissionHandler;

@Entity
@Getter
@Table(name = "mission")
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MissionStatus missionStatus = MissionStatus.IN_PROGRESS;

    @Builder.Default
    private int goalCount = 0;


    public void complete() {
        if (this.badge.getGoal() == this.goalCount) {
            this.missionStatus = MissionStatus.SUCCESS;
        }
    }

    public void countUp() {
        if (this.badge.getGoal() > this.goalCount) {
            throw MissionHandler.ALREADY_CLEAR;
        }
        this.goalCount++;
    }
}
