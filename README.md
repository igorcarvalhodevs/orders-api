## Orders API

REST API for order management built with Java, Spring Boot and PostgreSQL.

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
- Spring Data JPA
- PostgreSQL
- Flyway
- Docker
- Swagger (OpenAPI)

---

## Running locally

### Prerequisites
- Java 17+
- Docker
- Docker Compose

---

### Start PostgreSQL
```bash
docker-compose up -d
```

---

### Run the application
```bash
./mvnw spring-boot:run
```

---

### API Documentation
```bash
http://localhost:8080/swagger-ui/index.html
```

---

### Author
Igor Carvalho