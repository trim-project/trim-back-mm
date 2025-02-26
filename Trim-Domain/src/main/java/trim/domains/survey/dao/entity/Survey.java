package trim.domains.survey.dao.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import trim.common.model.BaseTimeEntity;

import java.util.List;

@Getter
@SuperBuilder
@Document(collection = "survey")
public class Survey extends BaseTimeEntity {
    @Id
    private String id;
    private String registerMemberId;
    private String title;
    private List<SurveyQuestion> surveyQuestionList;
}