package sobornov.event_log_service.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.time.Instant
import java.util.UUID

@Document(indexName = "events")
data class Event(
    @Id
    val id: UUID,
    val timestamp: Instant,
    val level: EventLevel,
    val service: String,
    val message: String
)
