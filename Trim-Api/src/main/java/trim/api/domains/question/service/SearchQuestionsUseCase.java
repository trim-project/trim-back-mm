package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.avatar.vo.response.stored.StoredAvatarResponse;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.question.mapper.QuestionMapper;
import trim.api.domains.question.vo.response.QuestionListResponse;
import trim.api.domains.question.vo.response.QuestionSummaryResponse;
import trim.common.annotation.UseCase;
import trim.common.util.EnumConvertUtil;
import trim.domains.board.business.adaptor.AnswerAdaptor;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.board.dao.domain.Question;
import trim.domains.like.business.adaptor.LikeAdaptor;
import trim.domains.tag.business.adaptor.TagAdaptor;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SearchQuestionsUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final TagAdaptor tagAdaptor;
    private final LikeAdaptor likeAdaptor;
    private final AnswerAdaptor answerAdaptor;

    public QuestionListResponse execute(String majorType, List<String> keyword, Pageable pageable) {
        MajorType convertedMajorType = null;
        if (majorType != null) {
            convertedMajorType = EnumConvertUtil.convert(MajorType.class, majorType);
        }
        Page<Question> questions = questionAdaptor.queryQuestionsBySearch(convertedMajorType, keyword, pageable);
        return QuestionListResponse.builder()
                .questionResponseList(
                        questions.getContent().stream()
                                .map(this::mapToQuestionSummaryResponse)
                                .toList()
                )
                .totalPages(questions.getTotalPages())
                .page(questions.getNumber())
                .build();
    }

    private QuestionSummaryResponse mapToQuestionSummaryResponse(Question question) {
        List<String> tags = tagAdaptor.queryNamesByBoardId(question.getId());

        return QuestionSummaryResponse.builder()
                .questionResponse(QuestionMapper.INSTANCE.toQuestionResponse(question))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(question.getWriter()))
                .storedAvatarResponse(StoredAvatarResponse.builder()
                        .backgroundColor(question.getWriter().getAvatar().getBackgroundColor())
                        .clothForURL(question.getWriter().getAvatar().getClothForURL())
                        .mouthForURL(question.getWriter().getAvatar().getMouthForURL())
                        .eyesForURL(question.getWriter().getAvatar().getEyesForURL())
                        .hairForURL(question.getWriter().getAvatar().getHairForURL())
                        .build())
                .likeCount(likeAdaptor.queryCountByBoard(question.getId()))
                .answerCount(answerAdaptor.queryCountByQuestionId(question.getId()))
                .tagList(tags)
                .build();
    }
}
