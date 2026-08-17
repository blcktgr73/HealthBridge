# Architecture

## 목적

Health Bridge는 제조사별 건강 앱에 직접 연결하지 않고 Android Health Connect를 표준 경계로 사용합니다. Health Connect에 데이터를 제공하는 앱이 Samsung Health인지 다른 앱인지는 Android 앱의 수집 로직과 분리합니다.

## 데이터 흐름

```text
Health Connect
  → Health Bridge Android app
  → HTTPS POST /v1/health/sync
  → Presephone/OpenClaw authenticated webhook
  → workspace health records and weekly summaries
```

## Ingress 결정

현재 가설은 Tailscale Funnel로 OpenClaw webhook을 외부 HTTPS endpoint로 공개하는 것입니다. 이 가설은 다음을 확인하는 Spike의 대상입니다.

- OpenClaw가 외부 HTTPS JSON webhook을 직접 수신할 수 있는가
- 인증 토큰 또는 서명 검증을 적용할 수 있는가
- 요청을 안정적으로 저장하거나 큐잉할 수 있는가
- 중복 요청과 재시작 이후 재처리를 안전하게 다룰 수 있는가

Spike가 통과하면 별도 Relay 없이 진행합니다. 통과하지 못하면 동일한 API 계약을 유지한 채 얇은 Ingestion Relay를 추가합니다. Android 앱은 특정 ingress 제품에 결합하지 않고 endpoint URL을 설정값으로 사용합니다.

## 채널 경계

Telegram session과 Discord 연결은 사람과 agent의 대화·제어·상태 알림 채널입니다. Health Bridge의 구조화된 건강 payload 수집 경로와는 분리합니다. 건강 원본 데이터는 메신저를 통과시키지 않습니다.

## 보안 경계

- 외부 endpoint는 HTTPS만 허용합니다.
- 기기별 인증 토큰 또는 HMAC 서명을 사용합니다.
- payload에는 이름, 전화번호, 정확한 위치 등 불필요한 식별 정보를 넣지 않습니다.
- 동일 payload 재전송은 idempotency key로 중복 처리하지 않습니다.
- 인증 실패, payload 오류, 일시적 서버 오류를 서로 다른 응답으로 구분합니다.
