package trim.domains.mission.business.adaptor;

import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;

public interface MissionAdaptor {

    Mission queryMissionByBadgeAndMember(Badge badge, Member member);
}
