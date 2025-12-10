package ru.practicum.ewm.model;

// Перечисление статусов события
public enum EventState {
    PENDING,            // Ожидает модерации
    PUBLISHED,          // Опубликовано
    MODERATION_FAILED,  // Модерация не пройдена (отклонено)
    CANCELED           // Отменено пользователем или администратором
}