package ru.practicum.ewm.model;

// Перечисление статусов события
public enum EventState {
    PENDING,    // Ожидает модерации
    PUBLISHED,  // Опубликовано
    CANCELED    // Отменено
}