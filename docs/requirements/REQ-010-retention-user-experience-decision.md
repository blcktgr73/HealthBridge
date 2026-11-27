---
id: REQ-010
type: requirement
title: 데이터 보관·삭제 및 Health Connect 사용자 경험 결정
status: needs-human-decision
owner: Human decision owner
story_ids: [US-001, US-002, US-003, US-004, US-010, US-023, US-024, US-025]
repository: blcktgr73/HealthBridge
---

# 데이터 보관·삭제 및 Health Connect 사용자 경험 결정

[#23](https://github.com/blcktgr73/HealthBridge/issues/23)의 보관·삭제와 사용자 동작을 구체화한다. [REQ-005](REQ-005-delivery-health-connect-contract.md)의 하위 의사결정이며 실제 건강 데이터 접근이나 저장의 승인이 아니다.

## Acceptance criteria

- `AC-001`: 원본·요약·전송 대기 데이터와 credential 각각의 저장 위치, 보관 기간, 접근 책임과 삭제 범위를 결정한다.
- `AC-002`: 삭제 요청·실패·재시작과 대기 데이터 처리에 대한 동작 및 확인 방법을 결정한다.
- `AC-003`: Health Connect 미설치·지원 불가·권한 거부·철회·데이터 없음 각각에 대한 안내와 사용자 재시도 경로를 결정한다.
- `AC-004`: 동기화 성공·실패와 마지막 상태의 표시 기준, 테스트 가능한 시나리오 및 미결정 사항을 기록한다.
- `AC-005`: 결정자·시각 및 실제 데이터·권한·외부 저장에 필요한 별도 승인 조건을 기록한다.

## Tasks

- `TASK-013` 보관·삭제와 복구 정책 결정 — [이슈 #28](https://github.com/blcktgr73/HealthBridge/issues/28)
- `TASK-014` Health Connect 및 동기화 상태 사용자 경험 결정 — [이슈 #29](https://github.com/blcktgr73/HealthBridge/issues/29)

## 의존성

수신 위치·전송 및 실패 계약은 REQ-009, 첫 사용자와 릴리스 범위는 REQ-006에 연결한다. 구현의 저장 방식이나 보관 기간은 결정 전 확정하지 않는다.
