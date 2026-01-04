# Orders API 

RESTful API built with Spring Boot for managing orders.  
The project demonstrates clean layered architecture, validation with meaningful error responses, database migrations with Flyway, API documentation via Swagger/OpenAPI, and Integration tests use Testcontainers to spin up a real PostgreSQL instance automatically, ensuring environment parity and reliable database validation.

This project was developed for study and portfolio purposes, following production-oriented practices.

---

### Features
- CRUD operations for orders
- Pagination and sorting with Spring Data Pageable
- API documentation with Swagger / OpenAPI
- Database versioning with Flyway
- PostgreSQL integration via Docker

---

### Tech Stack
- Java 17
- Spring Boot
- Spring Web + Spring Validation
- Spring Data JPA
- PostgreSQL
- Flyway (migrations)
- springdoc-openapi (Swagger UI)
- JUnit 5 + MockMvc
- Testcontainers (PostgreSQL)

---

## Running locally

### Requirements
- Java 17+
- Maven (or Maven Wrapper)
- PostgreSQL
- Docker (required only for integration tests with Testcontainers)

---

## Configure database

### Create a local PostgreSQL database (example):

- DB: `ordersdb`
- User: `orders`
- Password: `orders`

Update `src/main/resources/application.properties` accordingly.

---

### Start PostgreSQL
```bash
docker-compose up -d
```

---

### Run the application

## Windows:
```bash
./mvnw spring-boot:run
```

---

# Mac/Linux:
```bash
./mvnw spring-boot:run
```

---

### The API will start at:

- http://localhost:8080

---

### API Documentation (Swagger)

- Swagger UI: http://localhost:8080/swagger-ui/index.html

- OpenAPI JSON: http://localhost:8080/v3/api-docs

--- 

### Endpoints

## Create Order

## POST /orders
```JSON
{
  "customerEmail": "teste@teste.com",
  "totalCents": 1000
}
```

Responses:

- 201 Created with an OrderResponse

- 400 Bad Request with ApiError + violations

---

### Get Order By Id

## GET /orders/{id}

Responses:

- 200 OK with an OrderResponse

- 404 Not Found with ApiError

---

### List Orders (Paginated)

## GET /orders?page=0&size=20&sort=createdAt,desc

Response:

- 200 OK with a Spring Page<OrderResponse>

---

### Standard Error Response

## All errors return the same structure:

```JSON
{
  "timestamp": "2026-01-03T06:07:17.451166600Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/orders",
  "violations": [
    { "field": "customerEmail", "message": "customerEmail deve ser um e-mail válido" },
    { "field": "totalCents", "message": "totalCents deve ser maior ou igual a 0" }
  ]
}
```

---

### Database Migrations (Flyway)

## Migrations are located at:

- src/main/resources/db/migration

## They run automatically on startup.

### Running Tests
### Unit + Integration tests

- Windows:
```bash
.\mvnw clean test
```

- Mac/Linux:
```bash
./mvnw clean test
```

---

### Notes about Testcontainers

- Integration tests start a real PostgreSQL container automatically.

- Docker must be running for Testcontainers-based tests.

### Project Structure

- controller/ REST endpoints

- service/ business logic

- repository/ persistence layer

- entity/ JPA entities

- dto/ request/response DTOs

- exception/ custom exceptions and standardized error payload (ApiError)

---

## Author

Igor Carvalho

Backend developer focused on Java and Spring Boot.  
This project was developed for learning and portfolio purposes.
