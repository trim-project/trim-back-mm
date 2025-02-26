package trim.domains.survey.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import trim.domains.survey.dao.entity.Survey;

import java.util.Optional;

@Repository
public interface SurveyRepository extends MongoRepository<Survey, String> {
    // 특정 Survey 조회 (Survey ID 기준)
    Optional<Survey> findById(String id);
}
