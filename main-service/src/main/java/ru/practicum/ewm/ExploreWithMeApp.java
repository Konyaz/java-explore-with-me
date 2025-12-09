package ru.practicum.ewm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Главный класс для запуска основного сервиса приложения Explore With Me
@SpringBootApplication
public class ExploreWithMeApp {

    // Точка входа для запуска Spring Boot приложения основного сервиса
    public static void main(String[] args) {
        SpringApplication.run(ExploreWithMeApp.class, args);
    }
}