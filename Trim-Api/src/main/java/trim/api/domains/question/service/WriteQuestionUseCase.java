package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.question.mapper.QuestionMapper;
import trim.api.domains.question.vo.request.QuestionRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.business.service.QuestionDomainService;
import trim.domains.board.dao.domain.Question;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;
import trim.domains.tag.business.service.TagDomainService;


@Slf4j
@UseCase
@Transactional
@RequiredArgsConstructor
public class WriteQuestionUseCase {

    private final MemberAdaptor memberAdaptor;
    private final QuestionDomainService questionDomainService;
    private final TagDomainService tagDomainService;

    public Long execute(String username, QuestionRequest questionRequest) {
        log.info("username = {}", username);
        Member writer = memberAdaptor.queryMemberByUsername(username);
        Question question = questionDomainService.writeQuestion(
                writer,
                QuestionMapper.INSTANCE.toQuestionDto(questionRequest)
        );
        tagDomainService.addTagsInBoard(question.getId(), questionRequest.getTags());
        return question.getId();
    }

}
