package sobornov.event_log_service.service

import org.springframework.stereotype.Service
import sobornov.event_log_service.model.Event
import sobornov.event_log_service.repository.LogRepository

@Service
class LogService(
    private val repository: LogRepository,
) {
    fun save(event: Event) =
        repository.save(event)

}