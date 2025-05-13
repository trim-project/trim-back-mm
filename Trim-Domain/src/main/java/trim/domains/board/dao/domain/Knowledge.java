package trim.domains.board.dao.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.domains.board.dto.KnowledgeDto;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorValue("type_knowledge")
public class Knowledge extends Board{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MajorType majorType;

    @Column(nullable = false)
    private String title;

    public void edit(KnowledgeDto knowledgeDto) {
        super.edit(knowledgeDto.getTitle(), knowledgeDto.getContent());
        this.majorType = knowledgeDto.getMajorType();
    }
}
