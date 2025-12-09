package ru.practicum.ewm.model;

// Перечисление действий для изменения статуса события
public enum EventStateAction {
    SEND_TO_REVIEW,   // Отправить на рассмотрение (для пользователя)
    CANCEL_REVIEW,    // Отменить рассмотрение (для пользователя)
    REJECT_EVENT,     // Отклонить событие (для администратора)
    PUBLISH_EVENT     // Опубликовать событие (для администратора)
}