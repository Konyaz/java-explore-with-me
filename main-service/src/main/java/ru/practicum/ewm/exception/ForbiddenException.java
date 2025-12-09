package ru.practicum.ewm.exception;

// Исключение для случаев, когда доступ к ресурсу запрещен
public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
}