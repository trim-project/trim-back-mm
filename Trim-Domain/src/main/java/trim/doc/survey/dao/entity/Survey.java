package trim.doc.survey.dao.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import trim.common.model.MongoTimeEntity;

import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor // 기본 생성자 필요
@AllArgsConstructor
@Document(collection = "survey")
public class Survey extends MongoTimeEntity {
    @Id
    private String id;
    private String registerMemberId;
    private String title;
    private List<SurveyQuestion> surveyQuestionList;
}