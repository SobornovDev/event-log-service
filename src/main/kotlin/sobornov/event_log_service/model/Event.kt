package sobornov.event_log_service.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.time.Instant
import java.util.UUID

@Document(indexName = "events")
data class Event(
    @Id
    val id: UUID,
    @Field(type = FieldType.Date)
    val timestamp: Instant,
    @Field(type = FieldType.Keyword)
    val level: EventLevel,
    @Field(type = FieldType.Keyword)
    val service: String,
    @Field(type = FieldType.Text, analyzer = "standard")
    val message: String
)
