package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.question.dto.request.QuestionRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.domain.Member;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;
import trim.domains.question.service.QuestionDomainService;
import trim.domains.question.validate.QuestionValidate;

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
