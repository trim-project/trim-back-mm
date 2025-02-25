package trim.api.domains.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.answer.vo.AnswerRequest;
import trim.api.domains.knowledge.service.WriteKnowledgeUseCase;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.dao.domain.MajorType;

import java.util.List;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateAnswerDummyDataUseCase {

    private final WriteAnswerUseCase writeAnswerUseCase;

    public Boolean execute(Long questionId, Long memberId, int knowledgeCount) {
        for (int i = 0; i < knowledgeCount; i++) {
            AnswerRequest request = AnswerRequest.builder()
                    .title("title of answer" + i + "by" + memberId)
                    .content("content of answer" + i + "by" + memberId)
                    .build();
            writeAnswerUseCase.execute(questionId, memberId, request);
        }
        return true;
    }
}
