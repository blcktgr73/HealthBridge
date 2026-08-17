# Health Bridge

Health Bridge는 Android Health Connect에서 사용자가 허용한 건강 데이터를 읽어 Presephone/OpenClaw의 건강 기록 처리 계층으로 전달하는 오픈소스 Android 앱입니다.

## 현재 상태

설계 및 Spike 준비 단계입니다. 앱은 Android 기본 프로젝트로 초기화되어 있으며, Health Connect 연동과 외부 전송은 아직 구현되지 않았습니다.

## 목표 구조

```text
Samsung Health / 기타 Health Connect 제공 앱
                 ↓
          Android Health Connect
                 ↓ 읽기 전용
             Health Bridge
                 ↓ HTTPS POST
   Tailscale Funnel 또는 다른 HTTPS ingress
                 ↓
       Presephone/OpenClaw webhook
                 ↓
        workspace 건강 기록 처리
```

Tailscale Funnel은 현재 검증 대상인 ingress 선택지입니다. Android 앱은 Tailscale, Telegram, Discord session에 직접 의존하지 않으며, endpoint URL과 인증 설정을 구성값으로 사용합니다.

## 문서

- [요구 사항](docs/specs/USER_STORIES.md)
- [User Story Map](docs/specs/USER_STORY_MAP.md)
- [webhook 수신 Spike 계획](docs/specs/SPIKE_PLAN.md)
- [검증 기준](docs/specs/VERIFICATION.md)
- [데이터 계약](docs/specs/DATA_CONTRACT.md)
- [아키텍처 결정](docs/architecture.md)

## 개발 원칙

- Health Connect 읽기 권한만 요청하며 Health Connect에 데이터를 다시 쓰지 않습니다.
- 건강 원본 데이터를 Telegram이나 Discord 메시지로 전달하지 않습니다.
- 전송 endpoint는 인증·멱등성·재시도·삭제 처리를 지원해야 합니다.
- Presephone/OpenClaw webhook 직접 수신 가능 여부를 Spike로 확인한 뒤 Relay 도입 여부를 결정합니다.
