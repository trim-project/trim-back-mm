package trim.domains.survey.dao.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "survey_answer")
public class SurveyAnswer {
    @Id
    private String id;
    private String surveyId;
    private String respondentId;        //응답자 id
    private Map<String, Object> answers; // questionId -> 응답 값
    private String submittedAt;
}
