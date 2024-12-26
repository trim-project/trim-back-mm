package trim.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.member.domain.Member;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.repository.QuestionRepository;

@DomainService
@RequiredArgsConstructor
public class QuestionDomainServiceImpl implements QuestionDomainService{

    private final QuestionRepository questionRepository;
    private final QuestionAdaptor questionAdaptor;

    @Override
    public Long writeQuestion(Member member, CreateQuestionRequest dto) {
        Question newQuestion = dto.from(member);
        return questionRepository.save(newQuestion).getId();
    }

    @Override
    public void editQuestion(Member member, Long questionId, CreateQuestionRequest dto) {
        Question question = questionAdaptor.queryById(questionId);
        question.edit(dto);
    }

    @Override
    public void removeQuestion(Member member, Long questionId) {

    }
}
