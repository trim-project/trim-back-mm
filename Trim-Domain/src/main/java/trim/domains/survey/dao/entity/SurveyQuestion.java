package trim.domains.survey.dao.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class SurveyQuestion {
    public class Question {
        private String questionId;
        private String title;
        private String type;  // "radiogroup", "checkbox", "text", "text-multiple"
        private List<Choice> choices;  // 객관식 선택지 (주관식일 경우 null)
    }
}
