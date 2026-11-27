---
id: REQ-005
type: requirement
title: 실제 전송·보관·Health Connect 후속 제품 계약
status: draft
owner: Human decision owner
story_ids: [US-001, US-020]
repository: blcktgr73/HealthBridge
github_project: PALab Ops Kanban
---

# 실제 전송·보관·Health Connect 후속 제품 계약

## 배경

[#8](https://github.com/blcktgr73/HealthBridge/issues/8)의 합성/local-only 단계는 완료됐다. 현재 `daily_summary.steps`는 최근 7일 합계로 기록하고, 일별 payload 계약은 후속으로 남긴다. 이 요구사항은 실제 전송·보관·Health Connect를 구현하지 않고, 구현 전에 필요한 사람의 제품·보안 결정을 기록한다.

## 결정해야 할 계약

- 수신 대상과 실행 위치: 앱 내부 모듈인지 별도 agent/service인지
- 전송 방식: HTTP webhook/API 등과 endpoint·인증·idempotency·오류 응답
- 원본/요약 데이터 보관 기간, 삭제 요청·실패·재시작 동작
- Health Connect 미설치·권한 거부·권한 철회·데이터 없음 동작
- 실제 데이터 접근·전송·배포·secret/권한 변경의 승인 책임자

## Acceptance criteria

- `AC-001`: 위 계약 항목마다 선택지, 선택 결과, 결정자와 결정 시각이 기록된다.
- `AC-002`: 선택 결과가 데이터 경계·보안 책임·실패 동작과 함께 문서화된다.
- `AC-003`: `daily_summary.steps`의 현재 7일 합계 해석과 일별 계약의 후속 상태가 보존된다.
- `AC-004`: 사람 승인 전 실제 건강 데이터·Health Connect·외부 전송·외부 저장·배포·secret/권한 변경을 구현하지 않는다.
- `AC-005`: 결정 완료 후에만 후속 REQ/TASK와 구현 이슈를 만들고, 정확한 허용 파일·테스트·승인 경계를 연결한다.

## Tasks

- `TASK-006` 실제 전송·보관·Health Connect 계약 결정 — [GitHub Issue #23](https://github.com/blcktgr73/HealthBridge/issues/23)

## 세부 의사결정

- [REQ-009](REQ-009-receiving-transmission-decision.md): 수신·전송 계약 — TASK-011, TASK-012
- [REQ-010](REQ-010-retention-user-experience-decision.md): 보관·삭제와 사용자 경험 — TASK-013, TASK-014

이 작업들은 #23에 연결된 의사결정 세분화이며 구현 TASK가 아니다. 구현 이슈와 dispatch는 결정과 별도 승인 경계에 따른다.

## 현재 상태

결정 전 상태다. Morpheus dispatch 대상이 아니며, #23의 사람 결정 없이 실제 전송 구현을 시작하지 않는다.
