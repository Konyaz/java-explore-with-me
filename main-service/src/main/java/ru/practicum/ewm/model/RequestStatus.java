package ru.practicum.ewm.model;

// Перечисление статусов заявок на участие в событиях
public enum RequestStatus {
    PENDING,    // Ожидает рассмотрения
    CONFIRMED,  // Подтверждена
    REJECTED,   // Отклонена
    CANCELED    // Отменена пользователем
}