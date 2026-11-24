---
id: TASK-005
type: task
title: synthetic health.v1 로컬 전달 및 수신 검증
requirement: REQ-004
issue: https://github.com/blcktgr73/HealthBridge/issues/20
repository: blcktgr73/HealthBridge
assignee_type: agent
assignee: Morpheus
criteria: [AC-001, AC-002, AC-003, AC-004, AC-005]
tests: "ANDROID_HOME=/home/blcktgr/Android/Sdk ANDROID_SDK_ROOT=/home/blcktgr/Android/Sdk bash ./gradlew test"
---

# TASK-005 synthetic health.v1 로컬 전달 및 수신 검증

기존 `HealthV1PayloadFactory.fromSyntheticSteps`가 만든 synthetic `health.v1` payload를 동일 프로세스의 `InMemorySyntheticPayloadReceiver`에 전달하고, 수신 계약을 단위 테스트로 증명한다.

## 허용 파일

- `app/src/main/java/ai/palab/healthbridge/SyntheticPayloadDelivery.kt`
- `app/src/test/java/ai/palab/healthbridge/ExampleUnitTest.kt`

## 구현 경계

receiver는 메모리에서만 동작한다. non-synthetic payload와 지원하지 않는 schema version을 거부하고, 수신 payload의 schema version, synthetic marker, device ID, period start/end/timezone, 기존 steps 값을 보존해야 한다.

## 금지 범위

Health Connect, 실제 건강 데이터, 네트워크/API, 외부 저장, 배포, token/secret/권한, retry/idempotency, 큐를 추가하지 않는다. `daily_summary.steps`의 일별/7일 의미나 실제 agent endpoint를 결정하지 않는다.

## Blocker

`REQ-004`와 `TASK-005`가 `main`에 반영되기 전에는 Morpheus를 dispatch하지 않는다.

## 인계 및 증거

구현 전 Morpheus는 [#12](https://github.com/blcktgr73/HealthBridge/issues/12)의 최신 본문·전체 댓글과 [#20](https://github.com/blcktgr73/HealthBridge/issues/20)의 최신 본문·전체 댓글, REQ-004/TASK-005, AC-001~AC-005를 읽고 확인 댓글을 남긴다. 구현 후 변경 파일, commit, PR, 테스트 명령·결과와 이 로컬 전달 방식의 한계를 #20에 기록한다. Neo는 전체 chain과 실제 테스트 근거를 대조하며 증거가 없으면 완료 처리하지 않는다.
