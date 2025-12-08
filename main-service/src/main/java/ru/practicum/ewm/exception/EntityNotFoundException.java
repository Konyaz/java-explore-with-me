package ru.practicum.ewm.exception;

// Исключение для случаев, когда сущность не найдена в базе данных
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}