package ru.ifmo.core;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Модель фильтра для получения space marine.
 *
 * @author Andreey Barabanshchikov.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SpaceMarineFilterRequest extends PageDto {

    /**
     * Имя.
     */
    private String name;

    /**
     * Координата X.
     */
    private Coordinates coordinates;

    /**
     * Дата создания.
     */
    private ZonedDateTime creationDate;

    /**
     * Количество здоровья.
     */
    private Long health;

    /**
     * Класс персонажа.
     */
    private String category;

    /**
     * Тип оружия.
     */
    private String weaponType;

    /**
     * Тип оружия ближнего боя.
     */
    private String meleeWeapon;

    /**
     * Тип сортировки.
     */
    private String sortBy;

    /**
     * Порядок сортировки
     */
    private String order;

}
