package trim.api.domains.survey.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.doc.survey.dao.entity.SurveyQuestion;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class SurveyRequest {
    private final String title;
    private final List<SurveyQuestion> surveyQuestionList;
}
