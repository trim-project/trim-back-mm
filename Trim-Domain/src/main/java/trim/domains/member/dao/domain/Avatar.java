package trim.domains.member.dao.domain;

import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.domains.avatar.dao.entity.enums.*;

@Embeddable
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Avatar {

    @Enumerated(EnumType.STRING)
    private BackgroundColor backgroundColor;

    private String clothForURL;

    private String eyesForURL;

    private String hairForURL;

    private String mouthForURL;

}
