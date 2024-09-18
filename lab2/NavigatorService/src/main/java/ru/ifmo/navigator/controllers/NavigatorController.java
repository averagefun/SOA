package ru.ifmo.navigator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import ru.ifmo.core.Route;
import ru.ifmo.navigator.service.NavigatorService;

import java.util.List;

@RestController
@RequestMapping("/navigator")
public class NavigatorController {

    private final NavigatorService navigatorService;

    public NavigatorController(NavigatorService navigatorService) {
        this.navigatorService = navigatorService;
    }

    // Эндпоинт для поиска маршрута между локациями
    @GetMapping(value = "/route/{idFrom}/{idTo}/{shortest}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getRoute(
            @PathVariable("idFrom") Integer idFrom,
            @PathVariable("idTo") Integer idTo,
            @PathVariable("shortest") Boolean shortest) {
        try {
            if (idFrom == null || idTo == null || shortest == null) {
                return ResponseEntity.badRequest().body("Ошибка валидации запроса");
            }

            Route route = navigatorService.findRoute(idFrom, idTo, shortest);
            if (route == null) {
                return ResponseEntity.status(404).body("Маршрут не найден");
            }
            return ResponseEntity.ok(route);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутренняя ошибка сервера");
        }
    }

    // Эндпоинт для поиска всех маршрутов между локациями с сортировкой
    @GetMapping(value = "/routes/{idFrom}/{idTo}/{orderBy}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getRoutes(
            @PathVariable("idFrom") Integer idFrom,
            @PathVariable("idTo") Integer idTo,
            @PathVariable("orderBy") String orderBy) {
        try {
            if (idFrom == null || idTo == null || orderBy == null || orderBy.isEmpty()) {
                return ResponseEntity.badRequest().body("Ошибка валидации запроса");
            }

            List<Route> routes = navigatorService.findAllRoutes(idFrom, idTo, orderBy);
            if (routes.isEmpty()) {
                return ResponseEntity.status(404).body("Маршруты не найдены");
            }
            return ResponseEntity.ok(routes);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Внутренняя ошибка сервера");
        }
    }
}
