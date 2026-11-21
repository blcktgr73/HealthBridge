---
id: TASK-001
type: task
title: 합성 7일 걸음 요약 화면
requirement: REQ-001
issue: https://github.com/blcktgr73/HealthBridge/issues/4
repository: blcktgr73/HealthBridge
assignee_type: agent
assignee: Morpheus
pull_request: https://github.com/blcktgr73/HealthBridge/pull/5
tests: "gradlew test assembleDebug"
criteria: [AC-001, AC-004]
---

# TASK-001 합성 7일 걸음 요약 화면

합성 걸음 7일치와 총합·일평균을 표시한다. [PR #5](https://github.com/blcktgr73/HealthBridge/pull/5)가 main에 병합됐으며, 병합 전 날짜를 실행일 기준으로 보완하고 단위 테스트와 debug 빌드를 통과했다. 실제 건강 데이터와 네트워크 전송은 포함하지 않는다.
