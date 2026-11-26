package ai.palab.healthbridge

/**
 * Same-process receiver used to prove the synthetic health.v1 delivery path.
 * The payload is retained only for the lifetime of this receiver instance.
 */
class InMemorySyntheticPayloadReceiver {
    var receivedPayload: HealthV1Payload? = null
        private set

    fun receive(payload: HealthV1Payload) {
        require(payload.schemaVersion == HealthV1PayloadFactory.SCHEMA_VERSION) {
            "unsupported schema version: ${payload.schemaVersion}"
        }
        require(payload.isSyntheticFixture) {
            "only synthetic payloads are accepted"
        }
        receivedPayload = payload
    }
}
