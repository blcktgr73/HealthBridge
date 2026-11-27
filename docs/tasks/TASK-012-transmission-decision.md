---
id: TASK-012
type: task
title: 전송·인증·응답 계약 결정
requirement: REQ-009
issue: https://github.com/blcktgr73/HealthBridge/issues/27
repository: blcktgr73/HealthBridge
assignee_type: human
assignee: blcktgr73
criteria: [AC-002, AC-003, AC-004]
tests: "#23의 인증, 응답, 중복 및 실패 시나리오 검토"
---

# TASK-012 전송·인증·응답 계약 결정

TASK-011의 수신 경로를 바탕으로 전송 방식, endpoint 설정, 인증·credential 책임, payload 검증 및 응답을 결정한다. timeout, 재시도 가능 조건과 중복 방지에 대해 성공·인증 실패·잘못된 payload·중복·응답 유실 시나리오를 기록한다. 보관·삭제는 TASK-013과 조율한다. 결정자·시각과 별도 승인 조건을 #23에 기록한다. 네트워크 구현이나 secret 변경은 포함하지 않는다.
