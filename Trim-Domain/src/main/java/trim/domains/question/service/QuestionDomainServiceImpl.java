package trim.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.member.domain.Member;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.request.EditQuestionRequest;
import trim.domains.question.repository.QuestionRepository;
import trim.domains.question.validate.QuestionValidate;

@DomainService
@RequiredArgsConstructor
public class QuestionDomainServiceImpl implements QuestionDomainService{

    private final QuestionRepository questionRepository;
    private final QuestionAdaptor questionAdaptor;
    private final QuestionValidate questionValidate;

    @Override
    public Long writeQuestion(Member member, CreateQuestionRequest dto) {
        Question newQuestion = dto.from(member);
        return questionRepository.save(newQuestion).getId();
    }

    @Override
    public void editQuestion(Member member, Long questionId, EditQuestionRequest dto) {
        Question question = questionAdaptor.queryById(questionId);
        questionValidate.checkIsWriter(member, question);
        question.edit(dto);
    }

    @Override
    public void removeQuestion(Member member, Long questionId) {

    }
}
