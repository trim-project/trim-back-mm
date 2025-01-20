package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.question.dto.request.QuestionRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.dao.domain.Member;
import trim.domains.question.business.adaptor.QuestionAdaptor;
import trim.domains.question.dao.domain.Question;
import trim.domains.question.business.service.QuestionDomainService;
import trim.domains.question.business.validate.QuestionValidate;

@UseCase
@RequiredArgsConstructor
public class EditQuestionUseCase {

    private final QuestionDomainService questionDomainService;
    private final QuestionAdaptor questionAdaptor;
    private final QuestionValidate questionValidate;

    public void execute(Member writer, Long questionId, QuestionRequest request){
        Question question = questionAdaptor.queryById(questionId);
        questionValidate.checkIsWriter(writer, question);
        questionDomainService.editQuestion(question, request.from());
    }

}
