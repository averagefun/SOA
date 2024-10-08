package ru.ifmo.navigator.common;

/**
 * Список эндпоинтов второго сервиса.
 *
 * @author Andreey Barabanshchikov.
 */
public interface Endpoints {
    String CREATE_STARSHIP = "/starships";
    String GET_ALL_STARSHIPS = "/starships";
    String ADD_MARINE_TO_STARSHIP = "/starships/{starship-id}/load/{spacemarine-id}";
    String CLEAN_STARSHIP = "/starships/{id}/unload";
}
