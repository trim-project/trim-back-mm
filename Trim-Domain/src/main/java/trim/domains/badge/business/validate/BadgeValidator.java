package trim.domains.badge.business.validate;

import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;

public interface BadgeValidator {

    boolean countAllSelectedBadgeUnderThree(Member member);

    boolean notSelected(Mission mission);
}
