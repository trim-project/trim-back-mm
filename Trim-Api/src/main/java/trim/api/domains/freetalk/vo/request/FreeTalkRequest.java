package trim.api.domains.freetalk.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.board.dto.FreeTalkDto;

@Getter
@Builder
@RequiredArgsConstructor
public class FreeTalkRequest {

    private final String title;
    private final String content;

    public FreeTalkDto from() {
        return FreeTalkDto.builder()
                .content(this.content)
                .title(this.title)
                .build();
    }
}
