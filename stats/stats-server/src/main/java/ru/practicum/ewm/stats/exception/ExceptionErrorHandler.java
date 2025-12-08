package ru.practicum.ewm.stats.exception;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionErrorHandler {

    // Обработка ошибок валидации параметров методов контроллеров
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        String error = "Validation error";
        if (e.getBindingResult().getFieldError() != null) {
            error = e.getBindingResult().getFieldError().getField() + " "
                    + e.getBindingResult().getFieldError().getDefaultMessage();
        }

        log.warn("Validation failed: {}", error, e);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", error,
                        "status", HttpStatus.BAD_REQUEST.name(),
                        "reason", "Incorrectly made request",
                        "timestamp", LocalDateTime.now()
                ));
    }

    // Обработка ошибок несоответствия типов параметров
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
        String errorMessage = "Invalid parameter: " + e.getName();
        log.warn("Type mismatch for parameter '{}': {}", e.getName(), e.getValue(), e);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", errorMessage,
                        "status", HttpStatus.BAD_REQUEST.name(),
                        "reason", "Incorrectly made request",
                        "timestamp", LocalDateTime.now()
                ));
    }

    // Обработка исключений валидации
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(ValidationException e) {
        log.warn("Validation exception: {}", e.getMessage(), e);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", e.getMessage(),
                        "status", HttpStatus.BAD_REQUEST.name(),
                        "reason", "Incorrectly made request",
                        "timestamp", LocalDateTime.now()
                ));
    }

    // Обработка неверных аргументов
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException e) {
        log.warn("Illegal argument: {}", e.getMessage(), e);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", e.getMessage(),
                        "status", HttpStatus.BAD_REQUEST.name(),
                        "reason", "Incorrectly made request",
                        "timestamp", LocalDateTime.now()
                ));
    }

    // Глобальный обработчик всех необработанных исключений
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Map<String, Object>> handleUnexpected(Throwable e) {
        log.error("Unexpected error occurred", e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "error", "Internal server error",
                        "message", e.getMessage(),
                        "status", HttpStatus.INTERNAL_SERVER_ERROR.name(),
                        "reason", "Unexpected error occurred",
                        "timestamp", LocalDateTime.now()
                ));
    }
}