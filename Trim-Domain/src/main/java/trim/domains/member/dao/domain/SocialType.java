package trim.domains.member.dao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.security.Key;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum SocialType implements KeyedEnum {
    GOOGLE("google"), NAVER("naver"), KAKAO("kakao"), TRIM("trim");

    private final String key;
}