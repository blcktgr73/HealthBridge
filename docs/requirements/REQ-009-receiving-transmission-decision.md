---
id: REQ-009
type: requirement
title: 수신 및 전송 계약 결정
status: needs-human-decision
owner: Human decision owner
story_ids: [US-013, US-020, US-021, US-022, US-024]
repository: blcktgr73/HealthBridge
---

# 수신 및 전송 계약 결정

[#23](https://github.com/blcktgr73/HealthBridge/issues/23)의 수신·전송 결정 범위를 구체화한다. [REQ-005](REQ-005-delivery-health-connect-contract.md)의 하위 의사결정이며 제품 구현 승인이 아니다. 스토리 맵의 webhook 및 HTTPS는 설계 초안이다.

## Acceptance criteria

- `AC-001`: 수신 주체와 실행 위치의 선택지, 데이터 흐름, 선택 결과와 책임자를 기록한다.
- `AC-002`: 전송 방식과 endpoint 구성, 인증·credential 관리, 전송 데이터 범위 및 보안 책임을 결정한다.
- `AC-003`: payload 검증, 성공·실패 응답, timeout, 재시도 가능 여부 및 중복 방지의 동작과 검증 사례를 결정한다.
- `AC-004`: 결정자·시각과 미결정 항목을 기록하고, 실제 데이터 접근·외부 전송·배포·secret 변경의 별도 승인 조건을 명시한다.

## Tasks

- `TASK-011` 수신 대상과 데이터 흐름 결정 — [이슈 #26](https://github.com/blcktgr73/HealthBridge/issues/26)
- `TASK-012` 전송·인증·응답 계약 결정 — [이슈 #27](https://github.com/blcktgr73/HealthBridge/issues/27)

## 의존성

첫 사용자와 릴리스 범위는 REQ-006/TASK-007에, 데이터 보관·삭제 및 사용자 동작은 REQ-010에 연결한다. 현재 `daily_summary.steps`는 합성 단계의 최근 7일 합계이며 일별 계약은 미결정이다.
