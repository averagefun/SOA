package ru.ifmo.navigator.integration;

/**
 * Эндпоинты для взаимодействия с первым сервисом.
 *
 * @author Andreey Barabanshchikov.
 */
public interface EndpointsFirstService {
    String GET_SPACEMARINE = "/spacemarines/{id}";
    String UPDATE_SPACEMARINE = "/spacemarines/{id}";
}
