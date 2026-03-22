package sobornov.event_log_service.repository

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import sobornov.event_log_service.model.Event
import java.util.UUID

interface LogRepository : ElasticsearchRepository<Event, UUID>