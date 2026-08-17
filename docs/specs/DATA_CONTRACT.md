# Data Contract: `health.v1`

## 원칙

- 필요한 건강 모니터링 필드만 전송합니다.
- Health Connect 원본 레코드를 장기간 그대로 보관하지 않습니다.
- 시간은 ISO-8601 offset과 timezone을 함께 표현합니다.
- 없는 값은 `null` 또는 필드 생략으로 표현하고 0으로 추정하지 않습니다.

## MVP payload

```json
{
  "schema_version": "health.v1",
  "device_id": "stable-device-id",
  "period": {
    "start": "2026-08-16T00:00:00+09:00",
    "end": "2026-08-17T00:00:00+09:00",
    "timezone": "Asia/Seoul"
  },
  "daily_summary": {
    "steps": 9915,
    "distance_m": 7720,
    "active_calories_kcal": 311,
    "sleep_minutes": null
  },
  "exercise_sessions": [],
  "sleep_sessions": [],
  "sync": {
    "collected_at": "2026-08-16T23:35:00+09:00",
    "cursor": null,
    "deleted_record_ids": []
  }
}
```

## 전송 계약 초안

- Method: `POST`
- Path: `/v1/health/sync`
- Content-Type: `application/json`
- Authentication: device-scoped bearer token 또는 HMAC 서명
- Idempotency: `Idempotency-Key` header 필수

응답은 정상 접수, 인증 실패, payload 오류, 중복, 일시 오류를 구분해야 합니다. 실제 상태 코드와 응답 body는 webhook Spike에서 확정합니다.
