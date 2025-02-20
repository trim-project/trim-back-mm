package trim.common.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.badge.dao.repository.BadgeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class DataInitialize {

    private final BadgeRepository badgeRepository;

    @PostConstruct
    public void setUpBadge() {
        List<Badge> saveBadgeList = new ArrayList<>();
        //WRITE_QUESTION
        for (int i = 1; i <= 10; i++) {
            saveBadgeList.add(
                    Badge.builder()
                            .badgeTitle("write question" + i)
                            .badgeContent(BadgeContent.WRITE_QUESTION)
                            .goal(i * 5)
                            .level(i)
                            .build()
            );
        }
        //WRITE_ANSWER
        for (int i = 1; i <= 10; i++) {
            saveBadgeList.add(
                    Badge.builder()
                            .badgeTitle("write answer" + i)
                            .badgeContent(BadgeContent.WRITE_ANSWER)
                            .goal(i * 7)
                            .level(i)
                            .build()
            );
        }
        //WRITE_KNOWLEDGE
        for (int i = 1; i <= 10; i++) {
            saveBadgeList.add(
                    Badge.builder()
                            .badgeTitle("write knowledge" + i)
                            .badgeContent(BadgeContent.WRITE_KNOWLEDGE)
                            .goal(i * 5)
                            .level(i)
                            .build()
            );
        }

        //WRITE_FREE_TALK
        for (int i = 1; i <= 10; i++) {
            saveBadgeList.add(
                    Badge.builder()
                            .badgeTitle("write free_talk" + i)
                            .badgeContent(BadgeContent.WRITE_FREE_TALK)
                            .goal(i * 5)
                            .level(i)
                            .build()
            );
        }
        //WRITE_COMMENT
        for (int i = 1; i <= 10; i++) {
            saveBadgeList.add(
                    Badge.builder()
                            .badgeTitle("write comment" + i)
                            .badgeContent(BadgeContent.WRITE_COMMENT)
                            .goal(i * 10)
                            .level(i)
                            .build()
            );
        }
        //TODO GET_LIKE
        //TODO GET_ADOPTED
        //TODO PARTICIPATE_SURVEY
        badgeRepository.saveAll(saveBadgeList);
    }
}
