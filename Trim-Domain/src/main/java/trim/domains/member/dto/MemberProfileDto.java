package trim.domains.member.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberProfileDto {
    private final String name;
    private final String nickname;
    private final String major;
    private final String university;
    private final String description;
}
