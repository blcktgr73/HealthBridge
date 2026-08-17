# Webhook Ingestion Spike Plan

상태: 실행 전

## 질문

Tailscale Funnel로 외부에 공개한 OpenClaw endpoint가 Health Bridge의 `health.v1` JSON payload를 직접 안전하게 수신하고, Presephone/workspace 처리로 넘길 수 있는가?

## 가설

별도 Relay 없이 다음 경로를 사용할 수 있다.

`curl/Android test client → Tailscale Funnel → OpenClaw authenticated webhook → workspace adapter`

## 최소 실험

1. 테스트용 webhook 경로와 인증 토큰을 준비한다.
2. Tailscale Funnel을 통해 HTTPS endpoint를 외부에서 접근 가능하게 한다.
3. 작은 `health.v1` fixture를 `curl`로 POST한다.
4. 정상 요청의 응답 코드와 수신 로그를 확인한다.
5. 동일 idempotency key를 재전송하여 중복 처리를 확인한다.
6. 잘못된 토큰, 잘못된 schema, 과도한 기간 payload를 각각 전송한다.
7. OpenClaw 또는 adapter 재시작 후 처리 결과와 재시도 가능성을 확인한다.

## 성공 조건

- 외부 네트워크에서 HTTPS 연결 가능
- 인증 없는 요청은 거부
- 정상 `health.v1` payload는 `202 Accepted` 또는 계약된 성공 응답 수신
- 동일 idempotency key는 한 번만 반영
- 잘못된 payload는 재시도하지 않는 오류로 거부
- 일시적 오류는 Android가 재시도할 수 있는 응답으로 구분
- 수신 payload가 처리 로그 또는 안전한 저장 위치에 남음
- OpenClaw 재시작으로 이미 접수된 데이터가 유실되지 않음

## 산출물

- 실제 endpoint 계약
- 인증 방식과 secret 보관 방식
- 요청·응답 fixture
- 수신 로그 또는 처리 증거
- 실패한 조건과 Relay 도입 여부

## 주의

Funnel URL의 비공개성은 인증을 대체하지 않습니다. 실제 건강 데이터 대신 synthetic fixture로 먼저 실행합니다.
