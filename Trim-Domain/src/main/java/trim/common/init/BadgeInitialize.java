package trim.common.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import trim.common.util.StaticValues;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.badge.dao.repository.BadgeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static trim.common.util.StaticValues.*;

@Component
@Transactional
@RequiredArgsConstructor
public class BadgeInitialize {

    private final BadgeRepository badgeRepository;

    @PostConstruct
    public void setUpBadge() {
        // 기존 배지 제목을 한 번만 조회하여 Set으로 저장 (중복 체크 최적화)
        Set<String> existingBadgeTitles = new HashSet<>(badgeRepository.findAllBadgeTitles());

        List<Badge> saveBadgeList = new ArrayList<>();

        //WRITE_QUESTION
        for (int i = 0; i < 5; i++) {
            if (!existingBadgeTitles.contains(QUESTION_BADGE_TITLE.get(i))) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(QUESTION_BADGE_TITLE.get(i))
                                .badgeContent(BadgeContent.WRITE_QUESTION)
                                .goal(5 + 5 * i)
                                .point(5 + 5 * i)
                                .level(i + 1)
                                .build()
                );
            }
        }

        //WRITE_ANSWER
        for (int i = 0; i < 5; i++) {
            if (!existingBadgeTitles.contains(ANSWER_BADGE_TITLE.get(i))) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(ANSWER_BADGE_TITLE.get(i))
                                .badgeContent(BadgeContent.WRITE_ANSWER)
                                .goal(5 + 5 * i)
                                .point(5 + 5 * i)
                                .level(i + 1)
                                .build()
                );
            }
        }

        //WRITE_KNOWLEDGE
        for (int i = 0; i < 5; i++) {
            if (!existingBadgeTitles.contains(KNOWLEDGE_BADGE_TITLE.get(i))) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(KNOWLEDGE_BADGE_TITLE.get(i))
                                .badgeContent(BadgeContent.WRITE_KNOWLEDGE)
                                .goal(5 + 5 * i)
                                .point(5 + 5 * i)
                                .level(i + 1)
                                .build()
                );
            }
        }

        //WRITE_FREE_TALK
        for (int i = 0; i < 5; i++) {
            if (!existingBadgeTitles.contains(FREE_TALK_BADGE_TITLE.get(i))) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(FREE_TALK_BADGE_TITLE.get(i))
                                .badgeContent(BadgeContent.WRITE_FREE_TALK)
                                .goal(5 + 5 * i)
                                .point(5 + 5 * i)
                                .level(i + 1)
                                .build()
                );
            }
        }

        //WRITE_COMMENT
        for (int i = 0; i < 5; i++) {
            if (!existingBadgeTitles.contains(COMMENT_BADGE_TITLE.get(i))) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(COMMENT_BADGE_TITLE.get(i))
                                .badgeContent(BadgeContent.WRITE_COMMENT)
                                .goal(5 + 5 * i)
                                .point(5 + 5 * i)
                                .level(i + 1)
                                .build()
                );
            }
        }

        // TODO: GET_LIKE, GET_ADOPTED, PARTICIPATE_SURVEY 추가
        if (!saveBadgeList.isEmpty()) {
            badgeRepository.saveAll(saveBadgeList);
        }
    }
}