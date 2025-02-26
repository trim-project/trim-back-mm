package trim.api.domains.survey.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.survey.vo.request.SurveyRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.survey.business.service.SurveyDomainService;
import trim.domains.survey.dao.entity.Survey;

@UseCase
@RequiredArgsConstructor
public class RegisterSurveyUseCase {

    private final SurveyDomainService surveyDomainService;


    public String execute(Long memberId, SurveyRequest surveyRequest) {
        Survey survey = Survey.builder()
                .title(surveyRequest.getTitle())
                .registerMemberId(String.valueOf(memberId))
                .surveyQuestionList(surveyRequest.getSurveyQuestionList())
                .build();
        return surveyDomainService.createSurvey(survey).getId();
    }
}
