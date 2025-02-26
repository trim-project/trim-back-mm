package trim.domains.survey.dao.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "survey")
public class Survey {
    @Id
    private String id;
    private String title;
    private List<SurveyQuestion> surveyQuestionList;
    private String createdAt;
}