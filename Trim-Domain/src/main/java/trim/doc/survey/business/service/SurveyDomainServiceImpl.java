package trim.doc.survey.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.doc.survey.dao.entity.Survey;
import trim.doc.survey.dao.repository.SurveyAnswerRepository;
import trim.doc.survey.dao.repository.SurveyRepository;

@DomainService
@RequiredArgsConstructor
public class SurveyDomainServiceImpl implements SurveyDomainService{

    private final SurveyRepository surveyRepository;
    private final SurveyAnswerRepository surveyAnswerRepository;

    @Override
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }
}
