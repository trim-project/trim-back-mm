package trim.domains.like.dao.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.board.dao.domain.Board;
import trim.domains.member.dao.domain.Member;

@Entity
@Getter
@Table(name = "likes")
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Like extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    private Long memberId;

    private Long boardId;
}
