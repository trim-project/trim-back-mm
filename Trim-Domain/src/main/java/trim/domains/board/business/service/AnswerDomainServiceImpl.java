package trim.domains.board.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.board.dao.domain.Answer;
import trim.domains.board.dao.domain.BoardType;
import trim.domains.board.dao.repository.jpa.AnswerRepository;
import trim.domains.board.dto.AnswerDto;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class AnswerDomainServiceImpl implements AnswerDomainService{

    private final AnswerRepository answerRepository;

    @Override
    public Answer writeAnswer(AnswerDto dto, Member member, Long questionId) {
        Answer answer = Answer.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .questionId(questionId)
                .writer(member)
                .boardType(BoardType.ANSWER)
                .build();
        return answerRepository.save(answer);
    }
}
