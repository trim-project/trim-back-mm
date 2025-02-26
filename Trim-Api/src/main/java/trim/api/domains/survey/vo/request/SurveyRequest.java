package trim.api.domains.survey.vo.request;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.survey.dao.entity.SurveyQuestion;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class SurveyRequest {
    private String title;
    private List<SurveyQuestion> surveyQuestionList;
}
