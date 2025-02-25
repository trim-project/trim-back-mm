package trim.domains.mission.business.service;

import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;

public interface MissionDomainService {

    Mission createMission(Badge badge, Member member);

}
