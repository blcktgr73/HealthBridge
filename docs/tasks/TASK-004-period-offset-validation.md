---
id: TASK-004
type: task
title: health.v1 기간 offset 검증 강화
requirement: REQ-003
issue: https://github.com/blcktgr73/HealthBridge/issues/13
repository: blcktgr73/HealthBridge
assignee_type: agent
assignee: Morpheus
criteria: [AC-001, AC-002, AC-003, AC-004, AC-005]
tests: "ANDROID_HOME=/home/blcktgr/Android/Sdk ANDROID_SDK_ROOT=/home/blcktgr/Android/Sdk bash ./gradlew test"
---

# TASK-004 health.v1 기간 offset 검증 강화

`HealthV1Payload.kt`의 ISO-8601 offset 검증을 강화한다. 현재 합성 `health.v1` 모델의 기간 순서 검증은 유지하되, offset 시간·분 범위를 벗어난 입력과 잘못된 달력 값을 명시적으로 거부한다.

## 허용 파일

- `app/src/main/java/ai/palab/healthbridge/HealthV1Payload.kt`
- `app/src/test/java/ai/palab/healthbridge/ExampleUnitTest.kt`

## 금지 범위

실제 Health Connect 권한·읽기, 실제 건강 데이터, 네트워크/API, 외부 저장·전송, 배포, token/secret/권한 변경은 포함하지 않는다. `daily_summary.steps`의 일별·7일 의미를 새로 결정하지 않는다.

## Blocker

`REQ-003`과 `TASK-004` artifact 파일이 `main`에 반영되기 전에는 구현 dispatch를 하지 않는다.

## 인계 및 증거

구현 전 Morpheus는 [#12](https://github.com/blcktgr73/HealthBridge/issues/12)와 [#13](https://github.com/blcktgr73/HealthBridge/issues/13)의 최신 본문·전체 댓글, `REQ-003` 및 이 TASK를 읽고 확인 댓글을 남긴다. 구현 후 변경 파일, commit, PR, 실행 명령과 결과를 #13에 기록한다. Neo는 AC·변경 범위·실제 테스트 근거를 대조하며, 증거가 없으면 완료로 표시하지 않는다.
