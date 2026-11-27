---
id: REQ-007
type: requirement
title: 개발 협업과 Weaver 필드 표시 시험
status: in-progress
repository: blcktgr73/HealthBridge
---

# 개발 협업과 Weaver 필드 표시 시험

운영 및 협업 검증을 추적하는 요구사항이다. 제품 기능 요구사항이 아니다. 실제 건강 데이터는 시험 범위에 포함하지 않는다.

## Acceptance criteria

- `AC-001`: 준비된 합성 구현의 작업 분리, 인계, 검증 및 머지 근거를 기록한다.
- `AC-002`: 보드 협업 필드와 Weaver 설정을 대조하고 시험 결과 및 한계를 기록한다.
- `AC-003`: 실제 화면이나 전체 실행 경로 등 시험하지 않은 부분을 명시한다.

## Tasks

- `TASK-008` 구현부터 검증까지 협업 시험 — [GitHub Issue #3](https://github.com/blcktgr73/HealthBridge/issues/3)
- `TASK-009` Weaver 협업 필드 합성 시험 — [GitHub Issue #7](https://github.com/blcktgr73/HealthBridge/issues/7)

## 상태와 한계

두 이슈는 종료됐다. #7의 시험은 렌더링과 보드 값 대조이며 실제 VS Code 확장 호스트 및 GitHub 실시간 읽기 전체 경로의 검증은 아니다. 이 상태는 REQ 전체의 별도 수락을 뜻하지 않는다.
