package ru.ifmo.navigator.service;

import java.util.List;

import ru.ifmo.core.StarShipDto;
import ru.ifmo.core.StarShipRequest;

/**
 * Интерфейс сервиса работы с starship.
 *
 * @author Andreey Barabanshchikov.
 */
public interface StarshipService {

    /**
     * Создание корабля
     *
     * @param request модель корабля
     */
    void createStarship(StarShipRequest request);

    /**
     * Получение списка кораблей
     *
     * @return список всех кораблей
     */
    List<StarShipDto> getAllStarships();

    /**
     * Добавление десантника к кораблю
     *
     * @param spaceMarineId идентификатор десантника
     * @param starShipId    идентификатор корабля
     */
    void addMarineToStarship(Long spaceMarineId, Long starShipId);

    /**
     * Выгрузка всех десантников с корабля
     *
     * @param starShipId идентификатор корабля
     */
    void cleanStarship(Long starShipId);

}
