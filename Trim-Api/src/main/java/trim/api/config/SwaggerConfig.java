package trim.api.config;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import trim.api.common.dto.ApiResponseDto;
import trim.api.common.dto.ExampleHolder;
import trim.common.annotation.ApiErrorExceptionsExample;
import trim.common.annotation.ApiErrorStatusExample;
import trim.common.annotation.DisableSwaggerSecurity;
import trim.common.annotation.ExplainError;
import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;
import trim.common.exception.Reason;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static trim.common.util.StaticValues.*;

/** Swagger 사용 환경을 위한 설정 파일 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    private final ApplicationContext applicationContext;

    @Bean
    public OpenAPI openAPI(ServletContext servletContext) {
        String contextPath = servletContext.getContextPath();
        Server server = new Server().url(contextPath);
        return new OpenAPI()
                .servers(List.of(server))
                .components(authSetting())
                .addSecurityItem(new SecurityRequirement().addList(JWT))
                .info(swaggerInfo());
    }

    private Info swaggerInfo() {
        License license = new License();
        license.setUrl("https://github.com/trim-project/trim-back-mm");
        license.setName("TRIM");

        return new Info()
                .version("v0.0.1")
                .title("\"TRIM 서버 API문서\"")
                .description("TRIM 서버의 API 문서 입니다.")
                .license(license);
    }

    private Components authSetting() {
        return new Components()
                .addSecuritySchemes(
                        JWT,
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme(BEARER)
                                .bearerFormat(AUTHORIZATION)
                                .in(SecurityScheme.In.HEADER)
                                .name(JWT));
    }


    /**
     * 핸들러 메서드들의 정보를 스웨거에 등록 및 설정
     * @Operation
     * @Tag
     */
    @Bean
    public OperationCustomizer customize() {
        return (Operation operation, HandlerMethod handlerMethod) -> {
            DisableSwaggerSecurity methodAnnotation =
                    handlerMethod.getMethodAnnotation(DisableSwaggerSecurity.class);
            ApiErrorExceptionsExample apiErrorExceptionsExample =
                    handlerMethod.getMethodAnnotation(ApiErrorExceptionsExample.class);
            ApiErrorStatusExample apiErrorStatusExample =
                    handlerMethod.getMethodAnnotation(ApiErrorStatusExample.class);

            List<String> tags = getTags(handlerMethod);
            // DisableSecurity 어노테이션있을시 스웨거 시큐리티 설정 삭제
            if (methodAnnotation != null) {
                operation.setSecurity(Collections.emptyList());
            }
            // 태그 중복 설정시 제일 구체적인 값만 태그로 설정
            if (!tags.isEmpty()) {
                operation.setTags(Collections.singletonList(tags.get(0)));
            }
            // ApiErrorExceptionsExample 어노테이션 단 메소드 적용
            if (apiErrorExceptionsExample != null) {
                generateExceptionResponseExample(operation, apiErrorExceptionsExample.value());
            }
            // ApiErrorCodeExample 어노테이션 단 메소드 적용
            if (apiErrorStatusExample != null) {
                generateErrorStatusResponseExample(operation, apiErrorStatusExample.value());
            }
            return operation;
        };
    }
    /**
     * BaseErrorCode 타입의 이넘값들을 문서화 시킵니다. (-> ErrorStatus)
     * ExplainError 어노테이션으로 부가설명을 붙일수있습니다. 필드들을 가져와서 예시 에러 객체를
     * 동적으로 생성해서 예시값으로 붙입니다.
     */
    private void generateErrorStatusResponseExample(
            Operation operation, Class<? extends BaseErrorCode> type) {
        ApiResponses responses = operation.getResponses();

        BaseErrorCode[] errorCodes = type.getEnumConstants();

        Map<Integer, List<ExampleHolder>> statusWithExampleHolders =
                Arrays.stream(errorCodes)
                        .map(
                                baseErrorCode -> {
                                    try {
                                        Reason errorReason = baseErrorCode.getReasonHttpStatus();
                                        return ExampleHolder.builder()
                                                .holder(
                                                        getSwaggerExample(
                                                                baseErrorCode.getExplainError(),
                                                                errorReason))
                                                .code(errorReason.getCode())
                                                .name(errorReason.getHttpStatus().name())
                                                .build();
                                    } catch (NoSuchFieldException e) {
                                        throw new RuntimeException(e);
                                    }
                                })
                        .collect(groupingBy(ExampleHolder::getCode));

        addExamplesToResponses(responses, statusWithExampleHolders);
    }

    /**
     * SwaggerExampleExceptions 타입의 클래스를 문서화 시킵니다. SwaggerExampleExceptions 타입의 클래스는 필드로
     * GeneralException 타입을 가지며, GeneralException 의 errorReason 와,ExplainError 의 설명을
     * 문서화시킵니다.
     */
    private void generateExceptionResponseExample(Operation operation, Class<?> type) {
        ApiResponses responses = operation.getResponses();

        // ----------------생성
        Object bean = applicationContext.getBean(type);
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        Map<Integer, List<ExampleHolder>> statusWithExampleHolders =
                Arrays.stream(declaredFields)
                        .filter(field -> field.getAnnotation(ExplainError.class) != null)
                        .filter(field -> field.getType() == GeneralException.class)
                        .map(
                                field -> {
                                    try {
                                        GeneralException exception =
                                                (GeneralException) field.get(bean);
                                        ExplainError annotation =
                                                field.getAnnotation(ExplainError.class);
                                        String value = annotation.value();
                                        Reason errorReason = exception.getErrorReasonHttpStatus();
                                        return ExampleHolder.builder()
                                                .holder(getSwaggerExample(value, errorReason))
                                                .code(errorReason.getCode())
                                                .name(errorReason.getHttpStatus().name())
                                                .build();
                                    } catch (IllegalAccessException e) {
                                        throw new RuntimeException(e);
                                    }
                                })
                        .collect(groupingBy(ExampleHolder::getCode));

        // -------------------------- 콘텐츠 세팅 코드별로 진행
        addExamplesToResponses(responses, statusWithExampleHolders);
    }

    private Example getSwaggerExample(String value, Reason errorReason) {
        Example example = new Example();
        example.description(value);
        example.setValue(ApiResponseDto.onFailure(errorReason.getCode(), errorReason.getMessage(), false));
        return example;
    }

    private void addExamplesToResponses(
            ApiResponses responses, Map<Integer, List<ExampleHolder>> statusWithExampleHolders) {
        statusWithExampleHolders.forEach(
                (status, v) -> {
                    Content content = new Content();
                    MediaType mediaType = new MediaType();
                    ApiResponse apiResponse = new ApiResponse();
                    v.forEach(
                            exampleHolder -> {
                                mediaType.addExamples(
                                        exampleHolder.getName(), exampleHolder.getHolder());
                            });
                    content.addMediaType("application/json", mediaType);
                    apiResponse.setContent(content);
                    responses.addApiResponse(status.toString(), apiResponse);
                });
    }

    private static List<String> getTags(HandlerMethod handlerMethod) {
        List<String> tags = new ArrayList<>();
        // get tag method name
        Tag[] methodTags = handlerMethod.getMethod().getAnnotationsByType(Tag.class);
        List<String> methodTagStrings =
                Arrays.stream(methodTags).map(Tag::name).collect(Collectors.toList());
        // get class name
        Tag[] classTags = handlerMethod.getClass().getAnnotationsByType(Tag.class);
        List<String> classTagStrings =
                Arrays.stream(classTags).map(Tag::name).collect(Collectors.toList());

        tags.addAll(methodTagStrings);
        tags.addAll(classTagStrings);
        return tags;
    }
}
