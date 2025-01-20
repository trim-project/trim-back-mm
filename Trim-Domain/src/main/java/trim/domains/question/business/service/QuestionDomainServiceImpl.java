package trim.domains.question.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.member.dao.domain.Member;
import trim.domains.question.business.adaptor.QuestionAdaptor;
import trim.domains.question.dao.domain.Question;
import trim.domains.question.dto.QuestionDto;
import trim.domains.question.dao.repository.QuestionRepository;
import trim.domains.question.business.validate.QuestionValidate;

@DomainService
@RequiredArgsConstructor
public class QuestionDomainServiceImpl implements QuestionDomainService{

    private final QuestionRepository questionRepository;
    private final QuestionAdaptor questionAdaptor;
    private final QuestionValidate questionValidate;

    @Override
    public Long writeQuestion(Member member, QuestionDto dto) {
        Question newQuestion = Question.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return questionRepository.save(newQuestion).getId();
    }

    @Override
    public void editQuestion(Question question, QuestionDto dto) {
        question.edit(dto);
    }

    @Override
    public void deleteQuestion(Member member, Long questionId) {
        Question question = questionAdaptor.queryById(questionId);
        questionValidate.canDelete(member, question);
        // todo 여기에 삭제 로직

    }
}
