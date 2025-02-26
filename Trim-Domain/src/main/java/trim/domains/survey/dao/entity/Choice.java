package trim.domains.survey.dao.entity;

import lombok.Data;

@Data
public class Choice {
    private String choiceId; // 선택지 ID
    private String text; // 선택지 내용
}
