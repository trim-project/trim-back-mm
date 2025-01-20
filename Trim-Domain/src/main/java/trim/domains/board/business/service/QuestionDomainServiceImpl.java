package trim.domains.board.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.business.validate.BoardValidate;
import trim.domains.board.dao.domain.Question;
import trim.domains.board.dao.repository.QuestionRepository;
import trim.domains.member.dao.domain.Member;
import trim.domains.board.dto.QuestionDto;

@DomainService
@RequiredArgsConstructor
public class QuestionDomainServiceImpl implements QuestionDomainService{

    private final QuestionRepository questionRepository;
    private final QuestionAdaptor questionAdaptor;
    private final BoardValidate boardValidate;

    @Override
    public Long writeQuestion(Member member, QuestionDto dto) {
        //TODO add Tag
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
        boardValidate.canDelete(member, question);
        // todo 여기에 삭제 로직

    }
}
