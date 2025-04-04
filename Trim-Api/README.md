## External-API 모듈

### 🤝 Rule

- batch, worker, internal-api, external-api 등의 모듈과 묶일 수 있다.
- 사용성에 따라 다른 모든 계층에 의존성을 추가하여 사용할 수 있다.
- 웹 및 security 관련 라이브러리 의존성을 갖는다.
- Presentation Layer에 해당하는 Controller와 핵심 비즈니스 로직을 처리하는 Usecase를 포함한다.

### 🏷️ Directory Structure

```
Trim-Api
├── src
│   ├── main
│   │   ├── java.trim.api
│   │   │   ├── apis
│   │   │   ├── auth
│   │   │   ├── common 
│   │   │   ├── config
│   │   │   └── TrimApiServiceApplication.java
│   │   └── resources
│   │       └── application.yml
│   └── test
├── build.gradle
├── README.md
└── Dockerfile
```