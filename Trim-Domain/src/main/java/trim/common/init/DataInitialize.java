package trim.common.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.badge.dao.repository.BadgeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional
@RequiredArgsConstructor
public class DataInitialize {

    private final BadgeRepository badgeRepository;

    @PostConstruct
    public void setUpBadge() {
        // 기존 배지 제목을 한 번만 조회하여 Set으로 저장 (중복 체크 최적화)
        Set<String> existingBadgeTitles = new HashSet<>(badgeRepository.findAllBadgeTitles());

        List<Badge> saveBadgeList = new ArrayList<>();

        //WRITE_QUESTION
        for (int i = 1; i <= 10; i++) {
            String title = "write question" + i;
            if (!existingBadgeTitles.contains(title)) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(title)
                                .badgeContent(BadgeContent.WRITE_QUESTION)
                                .goal(i * 5)
                                .level(i)
                                .build()
                );
            }
        }

        //WRITE_ANSWER
        for (int i = 1; i <= 10; i++) {
            String title = "write answer" + i;
            if (!existingBadgeTitles.contains(title)) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(title)
                                .badgeContent(BadgeContent.WRITE_ANSWER)
                                .goal(i * 7)
                                .level(i)
                                .build()
                );
            }
        }

        //WRITE_KNOWLEDGE
        for (int i = 1; i <= 10; i++) {
            String title = "write knowledge" + i;
            if (!existingBadgeTitles.contains(title)) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(title)
                                .badgeContent(BadgeContent.WRITE_KNOWLEDGE)
                                .goal(i * 5)
                                .level(i)
                                .build()
                );
            }
        }

        //WRITE_FREE_TALK
        for (int i = 1; i <= 10; i++) {
            String title = "write free_talk" + i;
            if (!existingBadgeTitles.contains(title)) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(title)
                                .badgeContent(BadgeContent.WRITE_FREE_TALK)
                                .goal(i * 5)
                                .level(i)
                                .build()
                );
            }
        }

        //WRITE_COMMENT
        for (int i = 1; i <= 10; i++) {
            String title = "write comment" + i;
            if (!existingBadgeTitles.contains(title)) {
                saveBadgeList.add(
                        Badge.builder()
                                .badgeTitle(title)
                                .badgeContent(BadgeContent.WRITE_COMMENT)
                                .goal(i * 10)
                                .level(i)
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