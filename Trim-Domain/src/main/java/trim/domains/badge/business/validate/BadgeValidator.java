package trim.domains.badge.business.validate;

import trim.domains.member.dao.domain.Member;

public interface BadgeValidator {

    boolean countAllSelectedBadgeUnderThree(Member member);
}
