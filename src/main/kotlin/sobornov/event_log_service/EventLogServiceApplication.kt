package sobornov.event_log_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventLogServiceApplication

fun main(args: Array<String>) {
	runApplication<EventLogServiceApplication>(*args)
}
