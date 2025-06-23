package trim.api.domains.badge.vo.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;
import trim.domains.badge.dao.entity.BadgeContent;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Getter
@RequiredArgsConstructor
public enum BadgeContentDescription implements KeyedEnum {

    WRITE_QUESTION_5("질문 글 5개 작성하기", BadgeContent.WRITE_QUESTION,1),
    WRITE_QUESTION_10("질문 글 10개 작성하기", BadgeContent.WRITE_QUESTION,2),
    WRITE_QUESTION_15("질문 글 15개 작성하기", BadgeContent.WRITE_QUESTION,3),
    WRITE_QUESTION_20("질문 글 20개 작성하기", BadgeContent.WRITE_QUESTION,4),
    WRITE_QUESTION_25("질문 글 25개 작성하기", BadgeContent.WRITE_QUESTION,5),

    WRITE_ANSWER_5("대답 글 5개 작성하기", BadgeContent.WRITE_ANSWER,1),
    WRITE_ANSWER_10("대답 글 10개 작성하기", BadgeContent.WRITE_ANSWER,2),
    WRITE_ANSWER_15("대답 글 15개 작성하기", BadgeContent.WRITE_ANSWER,3),
    WRITE_ANSWER_20("대답 글 20개 작성하기", BadgeContent.WRITE_ANSWER,4),
    WRITE_ANSWER_25("대답 글 25개 작성하기", BadgeContent.WRITE_ANSWER,5),

    WRITE_KNOWLEDGE_5("지식 글 5개 작성하기", BadgeContent.WRITE_KNOWLEDGE,1),
    WRITE_KNOWLEDGE_10("지식 글 10개 작성하기", BadgeContent.WRITE_KNOWLEDGE,2),
    WRITE_KNOWLEDGE_15("지식 글 15개 작성하기", BadgeContent.WRITE_KNOWLEDGE,3),
    WRITE_KNOWLEDGE_20("지식 글 20개 작성하기", BadgeContent.WRITE_KNOWLEDGE,4),
    WRITE_KNOWLEDGE_25("지식 글 25개 작성하기", BadgeContent.WRITE_KNOWLEDGE,5),

    WRITE_FREE_TALK_5("자유 글 5개 작성하기", BadgeContent.WRITE_FREE_TALK,1),
    WRITE_FREE_TALK_10("자유 글 10개 작성하기", BadgeContent.WRITE_FREE_TALK,2),
    WRITE_FREE_TALK_15("자유 글 15개 작성하기", BadgeContent.WRITE_FREE_TALK,3),
    WRITE_FREE_TALK_20("자유 글 20개 작성하기", BadgeContent.WRITE_FREE_TALK,4),
    WRITE_FREE_TALK_25("자유 글 25개 작성하기", BadgeContent.WRITE_FREE_TALK,5),

    WRITE_COMMENT_5("댓글 5개 작성하기", BadgeContent.WRITE_COMMENT,1),
    WRITE_COMMENT_10("댓글 10개 작성하기", BadgeContent.WRITE_COMMENT,2),
    WRITE_COMMENT_15("댓글 15개 작성하기", BadgeContent.WRITE_COMMENT,3),
    WRITE_COMMENT_20("댓글 20개 작성하기", BadgeContent.WRITE_COMMENT,4),
    WRITE_COMMENT_25("댓글 25개 작성하기", BadgeContent.WRITE_COMMENT,5);


    private final String key;
    private final BadgeContent badgeContent;
    private final int level;

    // BadgeContent와 level이 일치하는 BadgeContentDescription Enum 값을 반환하는 메서드
    public static BadgeContentDescription from(BadgeContent badgeContent, int level) {
        return Arrays.stream(BadgeContentDescription.values()) // 모든 enum 상수를 스트림으로 변환
                .filter(b -> b.getBadgeContent().equals(badgeContent) && b.getLevel() == level) // 조건 필터링
                .findFirst() // 첫 번째 일치하는 요소를 찾음
                .orElseThrow(() -> new NoSuchElementException(
                        "No matching BadgeContentDescription found for BadgeContent: " + badgeContent + ", Level: " + level)); // 일치하는 것이 없으면 예외 발생
    }

    // 또는 Optional<BadgeContentDescription>을 반환하여 호출 측에서 처리하도록 할 수도 있습니다.
    public static java.util.Optional<BadgeContentDescription> findByContentAndLevel(BadgeContent badgeContent, int level) {
        return Arrays.stream(BadgeContentDescription.values())
                .filter(b -> b.getBadgeContent().equals(badgeContent) && b.getLevel() == level)
                .findFirst();
    }
}
