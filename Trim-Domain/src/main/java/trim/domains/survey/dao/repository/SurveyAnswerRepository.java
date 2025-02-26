package trim.domains.survey.dao.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import trim.domains.survey.dao.entity.AnswerStatistics;
import trim.domains.survey.dao.entity.SurveyAnswer;

import java.util.List;

@Repository
public interface SurveyAnswerRepository extends MongoRepository<SurveyAnswer, String> {
    // 특정 유저(respondent)의 설문 응답 조회
    @Query("{ 'surveyId': ?0, 'respondentId': ?1 }")
    List<SurveyAnswer> findBySurveyIdAndRespondentId(String surveyId, String respondentId);

    // 특정 주관식 질문의 응답 리스트 조회
    @Aggregation(pipeline = {
            "{ '$match': { 'surveyId': ?0 } }",
            "{ '$project': { '_id': 0, 'answer': '$answers.?1' } }"
    })
    List<String> findTextAnswersByQuestionId(String surveyId, String questionId);

    // 특정 객관식 질문의 응답 통계 조회
    @Aggregation(pipeline = {
            "{ '$match': { 'surveyId': ?0 } }",
            "{ '$unwind': '$answers.?1' }",  // 다중 선택을 위한 배열 분해
            "{ '$group': { '_id': '$answers.?1', 'count': { '$sum': 1 } } }",
            "{ '$sort': { 'count': -1 } }",
            "{ '$project': { 'choiceId': '$_id', 'count': 1, '_id': 0 } }"  // `_id` -> `choiceId`
    })
    List<AnswerStatistics> findChoiceStatisticsByQuestionId(String surveyId, String questionId);
}
