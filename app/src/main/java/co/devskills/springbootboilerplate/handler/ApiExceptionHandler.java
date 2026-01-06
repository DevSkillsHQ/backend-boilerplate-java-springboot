package co.devskills.springbootboilerplate.handler;

import java.time.Instant;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import co.devskills.springbootboilerplate.error.NotFoundException;
import co.devskills.springbootboilerplate.dto.ApiError;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ApiError> notFound(NotFoundException ex, HttpServletRequest req) {
        return build(HttpStatus.NOT_FOUND, ex.getMessage(), req.getRequestURI(), List.of());
    }

     private ResponseEntity<ApiError> build(
            HttpStatus status, String message, String path, List<ApiError.FieldError> fields
    ) {
        return ResponseEntity.status(status).body(
                new ApiError(Instant.now(), status.value(), status.getReasonPhrase(), message, path, fields)
        );
    }
}