package trim.api.common.resolver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import trim.common.annotation.AuthUser;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

import java.lang.annotation.Annotation;

@Slf4j
@RequiredArgsConstructor
public final class CustomAuthenticationPrincipalArgumentResolver implements HandlerMethodArgumentResolver {

    private final MemberAdaptor memberAdaptor;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return findMethodAnnotation(AuthUser.class, parameter) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();
        AuthUser annotation = findMethodAnnotation(AuthUser.class, parameter);
        if (principal == "anonymousUser") {
            throw new RuntimeException();
        }
        findMethodAnnotation(AuthUser.class, parameter);
        Member member = memberAdaptor.queryMemberByUsername(authentication.getName());

        if (principal != null && !ClassUtils.isAssignable(parameter.getParameterType(), member.getClass())) {
            if (annotation.errorOnInvalidType()) {
                throw new RuntimeException();
            }
        }

        return member;
    }

    private <T extends Annotation> T findMethodAnnotation(Class<T> annotationClass, MethodParameter parameter) {
        T annotation = parameter.getParameterAnnotation(annotationClass);
        if (annotation != null) {
            return annotation;
        }
        Annotation[] annotationsToSearch = parameter.getParameterAnnotations();
        for (Annotation toSearch : annotationsToSearch) {
            annotation = AnnotationUtils.findAnnotation(toSearch.annotationType(), annotationClass);
            if (annotation != null) {
                return annotation;
            }
        }
        return null;
    }
}
