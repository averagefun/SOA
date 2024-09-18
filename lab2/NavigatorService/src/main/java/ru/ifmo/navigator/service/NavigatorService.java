package ru.ifmo.navigator.service;

import org.springframework.stereotype.Service;
import ru.ifmo.core.Route;

import java.util.List;

@Service
public class NavigatorService {

    // Метод для получения самого короткого или длинного маршрута
    public Route findRoute(Integer idFrom, Integer idTo, Boolean shortest) {
        // Логика поиска маршрута
        // Здесь вы должны реализовать доступ к данным, например, через репозиторий
        // Для примера возвращаем заглушку
        return new Route();
    }

    // Метод для получения всех маршрутов между двумя локациями с сортировкой
    public List<Route> findAllRoutes(Integer idFrom, Integer idTo, String orderBy) {
        // Логика поиска маршрутов
        // Здесь вы должны реализовать доступ к данным, например, через репозиторий
        // Для примера возвращаем пустой список
        return List.of();
    }
}