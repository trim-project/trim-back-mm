package trim.domains.board.dao.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private MajorType majorType;

    public void edit(KnowledgeDto knowledgeDto) {
        super.edit(knowledgeDto.getTitle(), knowledgeDto.getContent());
        this.majorType = knowledgeDto.getMajorType();
    }
}
