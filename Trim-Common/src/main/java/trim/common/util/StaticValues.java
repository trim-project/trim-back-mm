package trim.common.util;

import java.util.List;

public class StaticValues {
    public final static String LIKE_CREATE_STATUS = "create";
    public final static String LIKE_REMOVE_STATUS = "remove";
    public final static String CORS_FRONT_LOCAL_PATH = "http://localhost:3000";
    public final static int HOT_ISSUE_COUNT = 6;
    public final static List<String> PERMIT_URL = List.of("/api/access/**");
    public final static List<String> SWAGGER_URL =
            List.of(
                    "/swagger-ui/**",
                    "/swagger-ui",
                    "/swagger-ui.html",
                    "/swagger/**",
                    "/swagger-resources/**",
                    "/v3/api-docs/**",
                    "/profile"
            );
    public final static List<String> DEFAULT_URL =
            List.of(
                    "/", "/.well-known/**", "/css/**", "/*.ico", "/error", "/images/**"
            );
    public final static List<String> OAUTH_URL =
            List.of("oauth/**");
    public static final String SWAGGER_JWT = "JWT";
    public static final String SWAGGER_BEARER = "Bearer";
    public static final String BEARER = "Bearer ";
    public static final String AUTHORIZATION = "Authorization";
    public static final String GRANT_TYPE = "authorization_code";
    public static final String STORAGE_PREFIX = "https://storage.googleapis.com/";
    public static final int HALF_HOUR = 1800000;
    public static final int ONE_MINUTE = 60000;
    public static final int SEVEN_DAYS = 604800000;
    public static final List<String> QUESTION_BADGE_TITLE =
            List.of(
                    "호기심 첫걸음",
                    "알쏭달쏭",
                    "궁금한 건 못 참아!",
                    "호기심 대장",
                    "물음표 수집가"
            );
    public static final List<String> ANSWER_BADGE_TITLE =
            List.of(
                    "초보 답변가",
                    "입문 조력자",
                    "명확한 답변가",
                    "성실한 답변가",
                    "해결사"
            );
    public static final List<String> KNOWLEDGE_BADGE_TITLE =
            List.of(
                    "지식 새싹",
                    "스터디룸",
                    "작은 도서관",
                    "알쓸신지",
                    "살아있는 데이터베이스"
            );
    public static final List<String> FREE_TALK_BADGE_TITLE =
            List.of(
                    "수줍은 글쓴이",
                    "쫑알쫑알",
                    "이야기꾼",
                    "이달의 작가",
                    "베스트셀러"
            );
    public static final List<String> COMMENT_BADGE_TITLE =
            List.of(
                    "첫 마디",
                    "리액션 장인",
                    "수다쟁이",
                    "댓글 요정",
                    "게시판 고정멤버"
            );

    public static final List<String> AVATAR_BADGE_TITLE =
            List.of(
                    "새내기 꼬까옷",
                    "옷장 탐색자",
                    "패션학과",
                    "패셔니스타",
                    "컬렉션 종결자"
            );

}
