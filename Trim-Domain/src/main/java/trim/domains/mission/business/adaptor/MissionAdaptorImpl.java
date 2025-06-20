package trim.domains.mission.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.badge.exception.BadgeHandler;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;
import trim.domains.mission.dao.repository.MissionRepository;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class MissionAdaptorImpl implements MissionAdaptor{

    private final MissionRepository missionRepository;

    @Override
    public Mission queryMissionByBadgeAndMember(Badge badge, Member member) {
        return missionRepository.findByBadgeAndMember(badge, member)
                .orElseThrow(() -> BadgeHandler.NOT_FOUND);
    }

    @Override
    public Mission queryMissionByBadgeIdAndMemberId(Long badgeId, Long memberId) {
        return missionRepository.findByBadgeIdAndMemberId(badgeId, memberId)
                .orElseThrow(() -> BadgeHandler.NOT_FOUND);
    }

    @Override
    public List<Mission> queryMissionByBadgeContentAndMember(BadgeContent badgeContent, Member member) {
        return missionRepository.findByMemberAndBadgeContent(member, badgeContent);
    }

    @Override
    public List<Mission> queryMissionByMemberId(Long memberId) {
        return missionRepository.findByMemberId(memberId);
    }

    @Override
    public List<Mission> queryMissionSelected(Member member) {
        return missionRepository.findByMemberAndIsSelectedBadgeTrue(member);
    }
}
