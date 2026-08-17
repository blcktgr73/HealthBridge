# Verification

## 문서 상태

초안. 구현과 Spike 결과에 따라 갱신합니다.

## Android 기본

- [ ] debug build가 성공한다.
- [ ] 지원 Android 버전과 Health Connect 미설치 상태의 안내가 정의되어 있다.
- [ ] 앱이 Health Connect에 데이터를 쓰지 않는다.
- [ ] 권한 철회 후 읽기 시도가 안전하게 실패한다.

## 수집

- [ ] 최근 7일 기본 범위를 확인할 수 있다.
- [ ] 페이지 토큰이 소진될 때까지 읽는다.
- [ ] 집계 데이터와 세션 데이터가 서로 다른 필드로 생성된다.
- [ ] null과 0을 구분한다.
- [ ] timezone과 날짜 경계가 보존된다.

## 전송

- [ ] HTTPS가 아닌 endpoint를 기본 허용하지 않는다.
- [ ] 잘못된 인증은 거부된다.
- [ ] schema version과 필수 필드를 검증한다.
- [ ] idempotency key 재전송이 중복 반영되지 않는다.
- [ ] 4xx와 5xx 응답의 재시도 정책이 다르다.
- [ ] 실패 payload가 로컬 큐에 남고 재시도된다.
- [ ] 사용자가 토큰과 대기 payload를 폐기할 수 있다.

## OpenClaw webhook Spike

- [ ] Tailscale Funnel 외부 접근
- [ ] 정상 synthetic payload 수신
- [ ] 인증 실패 거부
- [ ] payload 오류 거부
- [ ] 중복 요청 멱등 처리
- [ ] 재시작 후 접수 데이터 보존 또는 재처리

## Evidence ledger

| 항목 | 상태 | 증거 |
|---|---|---|
| Android 기본 빌드 | 미검증 | - |
| Health Connect 읽기 | 미검증 | - |
| `health.v1` 생성 | 미검증 | - |
| Funnel webhook 수신 | 미검증 | - |
| 인증·멱등성 | 미검증 | - |
| workspace 반영 | 미검증 | - |
