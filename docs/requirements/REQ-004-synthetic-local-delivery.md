---
id: REQ-004
type: requirement
title: 합성 health.v1 로컬 전달과 수신 검증
status: in-progress
owner: Neo
story_ids: [US-013, US-020]
repository: blcktgr73/HealthBridge
github_project: PALab Ops Kanban
---

# 합성 health.v1 로컬 전달과 수신 검증

## 배경과 결정

[#12](https://github.com/blcktgr73/HealthBridge/issues/12)의 의사결정에 따라, 실제 전송에 앞서 동일 프로세스의 메모리 receiver로 synthetic `health.v1` payload를 전달한다. 이 요구사항은 데이터 계약과 전달·수신 증거만 검증하며, 제품의 실제 agent endpoint나 외부 전송을 확정하지 않는다.

- 송신자: 기존 `HealthV1PayloadFactory.fromSyntheticSteps`
- 수신자: `InMemorySyntheticPayloadReceiver`
- 전달: 동일 프로세스의 메모리 호출
- 수명: 테스트·프로세스 종료 시 폐기

## Acceptance criteria

- `AC-001`: synthetic `health.v1` payload가 메모리 receiver에 전달된다.
- `AC-002`: receiver가 non-synthetic payload와 지원하지 않는 schema version을 거부한다.
- `AC-003`: 수신 payload의 schema version, synthetic marker, device ID, period start/end/timezone, 기존 steps 값이 보존된다.
- `AC-004`: 네트워크/API, 외부 저장, Health Connect, 실제 건강 데이터, 배포, token/secret/권한, retry/idempotency를 추가하지 않는다.
- `AC-005`: 구현 이슈·PR·변경 파일·테스트 명령·실행 결과·제한사항이 이 요구사항과 TASK에 연결된다.

## Tasks

- `TASK-005` synthetic health.v1 로컬 전달 및 수신 검증 — [GitHub Issue #20](https://github.com/blcktgr73/HealthBridge/issues/20)

## 미결정 사항

`daily_summary.steps`의 일별 값/7일 총합 의미, 실제 agent endpoint, 외부 전송·보관·삭제·재시도 계약은 확정하지 않는다. 이 결정은 해당 제품 계약을 대신하지 않는다.
