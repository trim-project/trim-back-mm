package trim.doc.survey.dao.entity;

import jakarta.persistence.Id;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import trim.common.model.BaseTimeEntity;
import trim.common.model.MongoTimeEntity;

import java.util.Map;

@SuperBuilder
@Document(collection = "survey_answer")
public class SurveyAnswer extends MongoTimeEntity {
    @Id
    private String id;
    private String surveyId;
    private String respondentId;        //응답자 id
    private Map<String, Object> answers; // questionId -> 응답 값
    private String submittedAt;
}
