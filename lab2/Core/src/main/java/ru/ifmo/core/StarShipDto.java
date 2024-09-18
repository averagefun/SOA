package ru.ifmo.core;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель передачи starship.
 *
 * @author Andreey Barabanshchikov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class StarShipDto {

    /**
     * Идентификатор.
     */
    private Long id;

    /**
     * Имя.
     */
    private String name;

    /**
     * Флотн.
     */
    private String fleet;

    /**
     * Координаты.
     */
    private Coordinates coordinates;

    /**
     * Здоровье.
     */
    private Long health;

    /**
     * Количество солдат.
     */
    private Long marinesCount;

    /**
     * ID десетников на корабле.
     */
    List<Long> spaceMarines;

}
