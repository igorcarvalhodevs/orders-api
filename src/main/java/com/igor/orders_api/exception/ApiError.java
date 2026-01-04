package com.igor.orders_api.exception;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.List;

@Schema(
        name = "ApiError",
        description = "Standard error response payload used by the API"
)
public class ApiError {

    @Schema(
            description = "Error timestamp in UTC",
            example = "2026-01-03T06:07:17.451166600Z"
    )
    private Instant timestamp;

    @Schema(description = "HTTP status code", example = "400")
    private int status;

    @Schema(description = "HTTP status reason phrase", example = "Bad Request")
    private String error;

    @Schema(description = "Human-readable error message", example = "Validation failed")
    private String message;

    @Schema(description = "Request path", example = "/orders")
    private String path;

    @ArraySchema(
            schema = @Schema(implementation = FieldViolation.class),
            arraySchema = @Schema(description = "Field-level validation errors (when applicable)")
    )
    private List<FieldViolation> violations;

    public ApiError(
            Instant timestamp,
            int status,
            String error,
            String message,
            String path,
            List<FieldViolation> violations
    ) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.violations = violations;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public List<FieldViolation> getViolations() {
        return violations;
    }

    /**
     * Represents a Bean Validation field error.
     */
    @Schema(name = "FieldViolation", description = "Validation error for a specific request field")
    public static class FieldViolation {

        @Schema(description = "Field name", example = "customerEmail")
        private String field;

        @Schema(description = "Validation message", example = "customerEmail deve ser um e-mail válido")
        private String message;

        public FieldViolation(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }
}

