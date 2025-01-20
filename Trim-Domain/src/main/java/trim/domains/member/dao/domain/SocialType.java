package trim.domains.member.dao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum SocialType {
    GOOGLE("google"), NAVER("naver"), KAKAO("kakao"), TRIM("trim");

    private final String key;

    public static SocialType converter(String key) {
        return Arrays.stream(SocialType.values())
                .filter(socialType -> socialType.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("not match any role"));
    }

}