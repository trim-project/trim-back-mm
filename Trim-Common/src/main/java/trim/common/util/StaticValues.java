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

}
