package sobornov.event_log_service.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import sobornov.event_log_service.model.Event
import sobornov.event_log_service.service.LogService

@RestController
@RequestMapping("api/v1/events")
@Tag(name = "Events", description = "Log Events")
class EventController(
    private val logService: LogService
) {

    @GetMapping("/search")
    @Operation(summary = "Search events by message")
    fun search(@RequestParam query: String): ResponseEntity<List<Event>> =
        ResponseEntity.ok(logService.search(query))

    @PostMapping
    @Operation(summary = "Create a new event")
    @ApiResponse(responseCode = "201", description = "Log created")
    fun create(@RequestBody event: Event): ResponseEntity<Event> {
        val created = logService.save(event)
        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(created.id)
            .toUri()
        return ResponseEntity.created(location).body(created)
    }
}