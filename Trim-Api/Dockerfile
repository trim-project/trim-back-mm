# 1단계: builder 스테이지
FROM openjdk:17-jdk-slim AS builder

WORKDIR /app

# Gradle wrapper 및 설정 관련 파일 복사
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .

# 모듈별 개별 build.gradle 복사
COPY Trim-Api/build.gradle /app/Trim-Api/
COPY Trim-Common/build.gradle /app/Trim-Common/
COPY Trim-Domain/build.gradle /app/Trim-Domain/
COPY Trim-Infra/build.gradle /app/Trim-Infra/

# config 폴더 복사 (YAML 및 인증파일 복사 작업)
COPY config /app/config

# 종속성 사전 다운로드 (캐시 최적화)
RUN ./gradlew dependencies --no-daemon

# 전체 소스 복사
COPY . .

# config 복사 스크립트 실행
RUN ./gradlew copyDomainConfig copyOauthConfig copyStorageConfig --no-daemon

RUN ls -al /app/Trim-Api/build/resources/main

RUN cat /app/Trim-Api/build/resources/main/application.yml

# Spring Boot 실행 JAR 생성
RUN ./gradlew :Trim-Api:bootJar -x test --no-daemon

# 실행 JAR 추출
RUN cp Trim-Api/build/libs/*.jar app.jar

# 2단계: 실행 스테이지 (더 가벼운 JRE 이미지)
FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /app/app.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
