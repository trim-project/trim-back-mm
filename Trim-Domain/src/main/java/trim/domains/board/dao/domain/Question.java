package trim.domains.board.dao.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.board.dao.domain.Board;
import trim.domains.member.dao.domain.Member;
import trim.domains.board.dto.QuestionDto;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorValue("type_question")
public class Question extends Board {

    @Enumerated(EnumType.STRING)
    private ResolveStatus resolveStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MajorType majorType;

    @Column(nullable = false)
    private String title;

    public void edit(QuestionDto dto) {
        super.edit(dto.getTitle(), dto.getContent());
        this.majorType = dto.getMajorType();
    }
}
