package trim.domains.survey.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.survey.dao.entity.Survey;
import trim.domains.survey.dao.repository.SurveyAnswerRepository;
import trim.domains.survey.dao.repository.SurveyRepository;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class SurveyAdaptorImpl implements SurveyAdaptor{

    private final SurveyRepository surveyRepository;
    private final SurveyAnswerRepository surveyAnswerRepository;

    @Override
    public Survey queryBySurveyId(String surveyId) {
        return surveyRepository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("survey_not_found"));
    }

    @Override
    public List<Survey> queryAll() {
        return surveyRepository.findAll();
    }
}
