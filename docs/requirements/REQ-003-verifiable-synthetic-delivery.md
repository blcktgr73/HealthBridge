---
id: REQ-003
type: requirement
title: 합성 health.v1 전달 경로의 검증 가능성
status: in-progress
owner: Neo
story_ids: [US-013, US-015]
repository: blcktgr73/HealthBridge
github_project: PALab Ops Kanban
---

# 합성 health.v1 전달 경로의 검증 가능성

## 배경과 범위

[#12](https://github.com/blcktgr73/HealthBridge/issues/12)의 첫 독립 개발 슬라이스다. 기존 합성 `health.v1` 모델이 잘못된 기간 경계를 거부하고 검증 가능한 근거를 남기는지 확인한다. 실제 Health Connect, 실제 건강 데이터, 네트워크·외부 전송·배포·secret은 범위 밖이다.

합성 payload의 일별 값과 7일 총합의 제품 계약은 아직 결정하지 않는다. 이 요구사항은 timestamp 형식·offset 검증과 로컬 단위 테스트에 한정한다.

## Acceptance criteria

- `AC-001`: ISO-8601 offset timestamp가 offset 시간·분 범위를 벗어나면 거부된다.
- `AC-002`: 유효한 `Z`, 양수 offset, 음수 offset timestamp는 기존 절대 시각 비교와 기간 순서 검증을 유지한다.
- `AC-003`: 잘못된 달력 값, 동일 기간, 역전 기간을 단위 테스트로 검증한다.
- `AC-004`: 실제 건강 데이터·Health Connect·네트워크/API·외부 저장·배포·token/secret/권한 변경을 추가하지 않는다.
- `AC-005`: 구현 이슈·PR·변경 파일·실행 명령·테스트 결과가 이 요구사항과 TASK에 연결된다.

## Tasks

- `TASK-004` 기간 offset 검증 강화 — [GitHub Issue #13](https://github.com/blcktgr73/HealthBridge/issues/13)

## 미결정 사항

`daily_summary.steps`가 일별 값인지 7일 총합인지와 실제 agent 간 전달·보관·삭제 계약은 [REQ-001](./REQ-001-synthetic-steps.md) 및 [#12](https://github.com/blcktgr73/HealthBridge/issues/12)에서 아직 결정되지 않았다. 이 TASK는 외부 전달을 구현하지 않는다.
