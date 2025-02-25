package trim.domains.mission.business.adaptor;

import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;

public interface MissionAdaptor {

    Mission queryMissionByBadgeAndMember(Badge badge, Member member);

    Mission queryMissionByBadgeIdAndMemberId(Long badgeId, Long memberId);

    Mission queryMissionByBadgeContentAndMember(BadgeContent badgeContent, Member member);
}
