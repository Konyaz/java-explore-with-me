package ru.practicum.ewm.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Главный класс для запуска сервиса статистики
@SpringBootApplication
public class StatsServiceApp {

    // Точка входа для запуска Spring Boot приложения сервиса статистики
    public static void main(String[] args) {
        SpringApplication.run(StatsServiceApp.class, args);
    }
}