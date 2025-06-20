package trim.domains.mission.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.exception.MissionHandler;

import static trim.domains.mission.dao.entity.MissionStatus.*;

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
    private MissionStatus missionStatus = LOCKED;

    @Builder.Default
    private Boolean isSelectedBadge = false;

    @Builder.Default
    private int goalCount = 0;


    public void complete() {
        this.missionStatus = SUCCESS;
    }

    public void countUp() {
        if (this.goalCount >= this.badge.getGoal()) {
            throw MissionHandler.ALREADY_CLEAR;
        }

        this.goalCount++;

        if (this.goalCount == this.badge.getGoal()) {
            complete();
        }
    }

    public void unlocked() {
        if (!this.missionStatus.equals(LOCKED)) {
            throw MissionHandler.WRONG_STATUS;
        }
        this.missionStatus = IN_PROGRESS;
    }

    public void selectBadge() {
        this.isSelectedBadge = true;
    }

    public void unselectBadge() {
        this.isSelectedBadge = false;
    }
}
