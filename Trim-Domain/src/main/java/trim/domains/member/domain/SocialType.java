package trim.domains.member.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SocialType {
    GOOGLE("google"), NAVER("naver"), KAKAO("kakao");

    private final String key;

}