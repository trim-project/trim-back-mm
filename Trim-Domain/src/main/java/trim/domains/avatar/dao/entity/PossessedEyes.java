package trim.domains.avatar.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import trim.domains.member.dao.domain.Member;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PossessedEyes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eyes_id", nullable = false)
    private Eyes eyes;
}
