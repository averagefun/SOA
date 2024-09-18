package ru.ifmo.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель запрса на саоздание Starship.
 *
 * @author Andreey Barabanshchikov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class StarShipRequest {

    /**
     * Имя.
     */
    private String name;

    /**
     * Флот.
     */
    private String fleet;

    /**
     * Координаты.
     */
    private Coordinates coordinates;

}
