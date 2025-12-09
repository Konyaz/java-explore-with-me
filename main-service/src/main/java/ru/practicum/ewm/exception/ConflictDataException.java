package ru.practicum.ewm.exception;

// Исключение для случаев конфликта данных (например, дублирование уникальных значений)
public class ConflictDataException extends RuntimeException {
    public ConflictDataException(String message) {
        super(message);
    }
}