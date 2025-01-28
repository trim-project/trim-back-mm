package trim.domains.board.business.service;

import trim.domains.board.dao.domain.Answer;
import trim.domains.board.dto.AnswerDto;
import trim.domains.member.dao.domain.Member;

public interface AnswerDomainService {

    Answer writeAnswer(AnswerDto dto, Member member, Long questionId);
}
