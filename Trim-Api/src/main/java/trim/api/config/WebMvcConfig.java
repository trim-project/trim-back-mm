package trim.api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import trim.api.common.resolver.CustomAuthenticationPrincipalArgumentResolver;
import trim.api.common.resolver.SplitRequestParamResolver;

import java.util.List;

import static trim.common.util.StaticValues.CORS_FRONT_LOCAL_PATH;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final SplitRequestParamResolver splitRequestParamResolver;
    private final CustomAuthenticationPrincipalArgumentResolver customAuthenticationPrincipalArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(splitRequestParamResolver);
        resolvers.add(customAuthenticationPrincipalArgumentResolver);
    }

    //CORS setting
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**") //CORS 적용할 URL 패턴
                .allowedOriginPatterns(CORS_FRONT_LOCAL_PATH) //자원 공유 오리진 지정
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") //요청 허용 메서드
                .allowedHeaders("*") //요청 허용 헤더
                .allowCredentials(true); //요청 허용 쿠키

    }
}
