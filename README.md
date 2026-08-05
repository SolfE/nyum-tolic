# 냠톨릭

가톨릭대학교 학생이 점심 메뉴를 빠르게 결정할 수 있도록, 교내 학식과 학교 주변 음식점 정보를 한곳에 모은 웹 서비스입니다.

2024년 가톨릭대학교 창업동아리 CSEC에서 5명이 함께 개발했습니다. 학기 중 일일 활성 사용자는 약 100명이었으며, 이 저장소에서는 서비스의 기능과 로컬 실행 방법을 정리합니다.

> 운영 주소: [nyumtolic.com](https://nyumtolic.com/restaurant/list)

## 저장소 운영 범위

이 저장소는 2024년 팀 프로젝트 개발을 마친 코드베이스에서 분기해, 개인적으로 확인한 운영·보안·유지보수 과제를 개선하고 그 근거를 기록하기 위한 작업 저장소입니다. 팀 프로젝트 당시 구현과 이후 개인 개선 작업은 커밋과 PR로 구분해 관리합니다.

## 서비스가 해결한 문제

학생의 점심 선택은 매일 반복되지만, 교내 학식 정보와 주변 음식점 정보는 흩어져 있고 신뢰할 만한 후기 역시 찾기 어려웠습니다. 냠톨릭은 학식 메뉴, 음식점 탐색, 학생 리뷰, 랜덤 추천을 하나의 흐름으로 연결했습니다.

| 학식 확인 | 음식점 탐색 | 메뉴 결정 |
| --- | --- | --- |
| 식당별 메뉴를 이미지와 PDF 뷰로 확인 | 카테고리·평점·거리 기준으로 탐색 | 조건에 맞는 음식점을 랜덤 추천 |

## 주요 기능

| 학생 리뷰 | 랜덤 추천 | 학식 정보 |
| --- | --- | --- |
| <img src="https://github.com/SolfE/nyum-tolic/assets/74342496/3540c5c4-d0ed-4a71-a314-42e898d08119" width="280" alt="음식점 리뷰 화면"> | <img src="https://github.com/SolfE/nyum-tolic/assets/74342496/23806200-35ca-4770-8609-d5b458450b4e" width="280" alt="음식점 랜덤 추천 화면"> | <img src="https://github.com/SolfE/nyum-tolic/assets/74342496/e54ecba5-c35c-4bc8-85ad-62598f93acb8" width="280" alt="학식 정보 화면"> |
| 학생이 남긴 별점과 후기를 제공 | 카테고리와 이전 추천 결과를 반영 | 학식 메뉴를 한 화면에서 제공 |

## 기술 구성

| 구분 | 기술 |
| --- | --- |
| Backend | Java, Spring Boot, Spring MVC, Spring Data JPA |
| View | Thymeleaf, Bootstrap |
| Security | Spring Security, 세션 기반 인증, Kakao OAuth2 |
| Database | H2(로컬 실행), PostgreSQL(운영 구성) |
| External | AWS S3, Cloudinary, JavaMail, Springdoc OpenAPI |
| Test | JUnit 5, MockMvc, Spring REST Docs |

## 로컬 실행

### 요구 사항

- JDK 21
- Gradle Wrapper
- 로컬 설정 파일: `src/main/resources/oauth.properties`, `mail.properties`, `aws.properties`

외부 연동에 필요한 값은 저장소에 포함하지 않습니다. 로컬에서 화면과 H2 데이터베이스를 확인할 때는 각 파일에 개발용 값을 설정하세요.

```bash
sh gradlew bootRun
```

서버가 시작되면 `http://localhost:8080/restaurant/list`에서 확인할 수 있습니다. H2 Console은 `http://localhost:8080/h2-console`에서 열립니다.

## 검증

```bash
sh gradlew test
sh gradlew compileJava
```
