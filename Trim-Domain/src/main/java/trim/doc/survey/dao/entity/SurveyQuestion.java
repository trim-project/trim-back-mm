package trim.doc.survey.dao.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class SurveyQuestion {
    private String questionId;
    private String title;
    private String type;  // "radiogroup", "checkbox", "text", "text-multiple"
    private List<Choice> choices;
}
