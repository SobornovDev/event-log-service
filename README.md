# event-log-service

Kotlin / Spring Boot service that stores and queries application events.

Companion piece to [audit-spring-boot-starter](https://github.com/SobornovDev/audit-spring-boot-starter): the starter emits events, this service keeps them searchable.

## Stack

- Kotlin, Spring Boot
- Docker Compose for local dependencies (`compose.yaml`)
- Postman collection in the repo root

## Run

```bash
docker compose up -d
./gradlew bootRun
```

Import `event-log-service.postman_collection.json` to hit the API.

## Portfolio note

Small service, on purpose. Reviewers should look at module boundaries and the compose setup, not at feature count.

MIT © Vladimir Sobornov
