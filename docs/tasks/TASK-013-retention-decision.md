---
id: TASK-013
type: task
title: 보관·삭제와 복구 정책 결정
requirement: REQ-010
issue: https://github.com/blcktgr73/HealthBridge/issues/28
repository: blcktgr73/HealthBridge
assignee_type: human
assignee: blcktgr73
criteria: [AC-001, AC-002, AC-005]
tests: "#23의 데이터별 수명과 삭제·실패·재시작 시나리오 검토"
---

# TASK-013 보관·삭제와 복구 정책 결정

원본, 요약, 전송 대기 데이터와 credential 각각에 대해 저장 위치·기간·접근 책임·삭제 범위를 정한다. 삭제 요청, 삭제 실패, 앱 또는 수신 측 재시작, 대기 데이터의 처리와 사용자 확인 방법을 결정한다. TASK-011·012의 데이터 경로와 조율하고 결정자·시각 및 별도 승인 조건을 #23에 기록한다. 실제 데이터 저장과 삭제 구현은 포함하지 않는다.
