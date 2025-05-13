package trim.domains.board.dao.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;
import trim.domains.board.dao.domain.Board;
import trim.domains.board.dto.FreeTalkDto;
import trim.domains.member.dao.domain.Member;
import trim.domains.board.dto.QuestionDto;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@DiscriminatorValue("type_free_talk")
public class FreeTalk extends Board {

    @Column(nullable = false)
    private String title;

    public void edit(FreeTalkDto dto) {
        super.edit(dto.getContent());
        this.title = dto.getTitle();
    }
}
