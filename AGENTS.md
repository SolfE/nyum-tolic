# AGENTS.md

이 문서는 냠톨릭 저장소에서 작업하는 AI 도구를 위한 최소 운영 규칙이다.
외부 방문자용 서비스 소개와 포트폴리오 내용은 루트 [README.md](README.md)에서 관리한다.

## 작업 대상 저장소

- 모든 GitHub 작업은 개인 저장소 `SolfE/nyum-tolic`을 기준으로 한다.
- `origin`은 정규화했을 때 `https://github.com/SolfE/nyum-tolic.git` 또는 `git@github.com:SolfE/nyum-tolic.git`이어야 한다.
- 원본 팀 저장소나 다른 upstream 저장소에 push하거나 cross-repository PR을 만들지 않는다.
- branch 생성, push, PR 생성 전에는 `git remote -v`로 대상 원격을 확인한다.
- PR의 기본 대상은 이 저장소의 `master` 브랜치다.

## 브랜치 규칙

기본 형식은 다음과 같다.

```text
<type>/<short-description>
```

Codex가 만드는 브랜치는 작업 추적을 위해 다음 형식을 사용한다.

```text
codex/<type>/<short-description>
```

사용하는 type은 다음과 같다.

- `feat`: 사용자 기능 추가
- `fix`: 버그 수정
- `refactor`: 동작 변경 없는 구조 개선
- `docs`: 문서 변경
- `hotfix`: 긴급 수정
- `test`: 테스트 추가 또는 수정
- `chore`: 빌드, 설정, 운영 보조 변경

## 커밋 규칙

기본 형식은 다음과 같다.

```text
<type>(<scope>): <summary>
```

scope가 명확하지 않으면 생략한다.

```text
<type>: <summary>
```

- summary는 짧은 영어 소문자 명령형으로 작성한다.
- 한 커밋에는 하나의 의도만 담는다.
- 문서 변경에는 `docs:`를 사용한다.

예시:

```text
docs: refine project readme
fix(security): resolve deferred csrf token before partial output
test(review): add csrf rendering regression coverage
```

## PR 규칙

- PR 제목은 대표 커밋 메시지 형식을 따른다.
- PR 본문에는 다음 섹션을 모두 작성한다.
  - `Summary`
  - `Problem`
  - `Solution`
  - `Changes`
  - `Example`
  - `Related Issues`
- 해당 사항이 없는 섹션은 비워 두지 말고 `없음` 또는 문서 변경임을 명시한다.
- 관련 없는 변경은 같은 PR에 섞지 않는다.
- 초안 PR을 기본으로 만들고, ready for review 전환은 사용자의 요청이 있을 때만 한다.

## 변경 전후 확인

- 작업 전과 스테이징 전에는 `git status -sb`와 `git diff`로 변경 범위를 확인한다.
- 혼합된 작업 트리에서는 명시한 파일만 stage한다.
- 코드 변경은 영향 범위에 맞는 테스트나 실행 검증 근거를 남긴다.
- 문서 변경은 링크와 명령 예시가 유효한지 확인한다.
- 비밀 값, 운영 자격 증명, 개인 정보는 커밋하거나 PR 본문에 기록하지 않는다.
