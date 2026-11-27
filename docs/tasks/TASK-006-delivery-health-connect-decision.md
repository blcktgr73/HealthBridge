---
id: TASK-006
type: task
title: 실제 전송·보관·Health Connect 계약 결정
requirement: REQ-005
issue: https://github.com/blcktgr73/HealthBridge/issues/23
repository: blcktgr73/HealthBridge
assignee_type: human
assignee: blcktgr73
criteria: [AC-001, AC-002, AC-003, AC-004, AC-005]
tests: "Decision review: record selected options, decision owner, timestamp, and approval on issue #23"
---

# TASK-006 실제 전송·보관·Health Connect 계약 결정

#8의 다음 단계로 실제 전송·보관·Health Connect 관련 제품 계약을 결정한다. 이 TASK는 문서·의사결정 작업이며 코드 구현이 아니다.

## 허용 파일

- `docs/requirements/REQ-005-delivery-health-connect-contract.md`
- `docs/tasks/TASK-006-delivery-health-connect-decision.md`

## 결정 항목

1. 수신 대상과 실행 위치
2. 전송 방식, endpoint, 인증, idempotency, 오류 응답
3. 원본/요약 보관 기간과 삭제·재시작 동작
4. Health Connect 미설치·권한 거부·권한 철회·데이터 없음 동작
5. 실제 데이터·외부 전송·배포·secret/권한 변경의 승인 책임자

## 금지 범위

사람의 결정과 승인 전에는 Health Connect 권한 요청, 실제 건강 데이터 읽기, HTTP/API, 외부 저장·전송, 배포, token/secret/권한 변경을 하지 않는다. `daily_summary.steps`의 현재 해석은 최근 7일 합계로 유지하며, 일별 계약은 별도 결정으로 남긴다.

## Blocker

#23의 사람 결정과 승인 전에는 Morpheus 구현 이슈를 만들거나 dispatch하지 않는다.

## 증거

#23에 각 항목의 선택지, 선택 결과, 결정자, 결정 시각, 데이터·보안 경계, 실패 동작과 후속 구현 조건을 기록한다. 결정이 끝나면 Neo가 REQ/TASK/AC/허용 파일/테스트를 갱신하고 별도 구현 이슈를 만든다.
