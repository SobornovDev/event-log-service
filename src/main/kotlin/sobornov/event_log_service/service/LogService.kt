package sobornov.event_log_service.service

import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.query.Criteria
import org.springframework.data.elasticsearch.core.query.CriteriaQuery
import org.springframework.data.elasticsearch.core.search
import org.springframework.stereotype.Service
import sobornov.event_log_service.model.Event
import sobornov.event_log_service.repository.LogRepository

@Service
class LogService(
    private val repository: LogRepository,
    private val operations: ElasticsearchOperations,
) {
    fun save(event: Event) =
        repository.save(event)

    fun search(query: String): List<Event> {
        val criteria = Criteria("message").matches(query)
        val q = CriteriaQuery(criteria)
        return operations.search<Event>(q).searchHits.map { it.content }
    }

}