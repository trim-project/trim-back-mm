package trim.api.common.util;

import org.mapstruct.Named;
import trim.common.util.EnumConvertUtil;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.member.dao.domain.SocialType;

public class EnumMappingUtil {

    @Named("stringToMajorType")
    public static MajorType stringToMajorType(String majorType) {
        return EnumConvertUtil.convert(MajorType.class, majorType);
    }

    @Named("stringToSocialType")
    public static SocialType stringToSocialType(String socialType) {
        return EnumConvertUtil.convert(SocialType.class, socialType);
    }
}
