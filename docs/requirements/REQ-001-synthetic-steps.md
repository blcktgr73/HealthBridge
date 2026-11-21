---
id: REQ-001
type: requirement
title: 합성 걸음 데이터 요약과 정규화
status: in-progress
owner: Neo
story_ids: [US-010, US-013, US-014, US-015]
repository: blcktgr73/HealthBridge
github_project: PALab Ops Kanban
---

# 합성 걸음 데이터 요약과 정규화

## 배경과 범위

[사용자 스토리 맵](../specs/USER_STORY_MAP.md)과 [사용자 스토리](../specs/USER_STORIES.md)의 첫 슬라이스 중 합성 데이터로 검증할 수 있는 부분이다. [#2의 결정](https://github.com/blcktgr73/HealthBridge/issues/2#issuecomment-7063028906)에 따라 실제 건강 데이터는 사용하지 않는다. 이 요구사항은 실제 Health Connect 수집이나 전송의 완료를 뜻하지 않는다.

## Acceptance criteria

- 합성 데이터임을 표시하고 실행일 기준 7일의 날짜별 합성 걸음 수와 계산된 총합·일평균을 화면에 보여준다.
- 합성 걸음 요약을 `health.v1` 모델로 변환하며 전달받은 기간과 timezone을 보존하고 잘못된 기간을 거부한다.
- 미수집 수치는 null, 미수집 세션은 빈 목록으로 표현하며 합성 fixture임을 구분한다.
- 합계·평균과 모델 변환을 단위 테스트로 검증하며 실제 건강 데이터 읽기나 네트워크 전송을 추가하지 않는다.

## Tasks

- `TASK-001` 합성 7일 걸음 요약 화면 — [GitHub Issue #4](https://github.com/blcktgr73/HealthBridge/issues/4)
- `TASK-002` 합성 걸음 요약을 health.v1 모델로 정규화 — [GitHub Issue #9](https://github.com/blcktgr73/HealthBridge/issues/9)

## 미결정 사항

[데이터 계약](../specs/DATA_CONTRACT.md)의 일별 요약과 7일 기간의 관계는 [#2](https://github.com/blcktgr73/HealthBridge/issues/2)에서 결정되지 않았다. 현재 모델은 7일 총합을 `dailySummary.steps`에 담는 합성 시험 구현이므로 실제 일별 payload 계약으로 간주하지 않는다. JSON 직렬화와 agent 전달은 별도 작업이다.
