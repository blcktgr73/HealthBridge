---
id: TASK-002
type: task
title: 합성 걸음 요약을 health.v1 모델로 정규화
requirement: REQ-001
issue: https://github.com/blcktgr73/HealthBridge/issues/9
repository: blcktgr73/HealthBridge
assignee_type: agent
assignee: Morpheus
pull_request: https://github.com/blcktgr73/HealthBridge/pull/10
tests: "gradlew test assembleDebug"
criteria: [AC-002, AC-003, AC-004]
---

# TASK-002 합성 걸음 요약을 health.v1 모델로 정규화

[PR #10](https://github.com/blcktgr73/HealthBridge/pull/10)이 main에 병합됐다. Morpheus 구현을 Neo가 검토했고, 병합 전 단위 테스트와 debug 빌드가 통과했다. JSON 직렬화와 전송은 범위 밖이다. 기간과 일별 집계의 의미는 [REQ-001](../requirements/REQ-001-synthetic-steps.md)의 미결정 사항을 따른다.
