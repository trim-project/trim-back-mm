package trim.doc.survey.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import trim.doc.survey.dao.entity.Survey;

import java.util.Optional;


public interface SurveyRepository extends MongoRepository<Survey, String> {
    // 특정 Survey 조회 (Survey ID 기준)
    Optional<Survey> findById(String id);
}
