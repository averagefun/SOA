package ru.ifmo.core;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ifmo.core.enums.AstartesCategory;
import ru.ifmo.core.enums.MeleeWeapon;
import ru.ifmo.core.enums.Weapon;

/**
 * Модель Space Marine.
 *
 * @author Andreey Barabanshchikov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SpaceMarineResponse {

    /**
     * Идентификатор.
     */
    private Long id;

    /**
     * Имя.
     */
    private String name;

    /**
     * Координаты.
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
    private AstartesCategory category;

    /**
     * Тип оружия.
     */
    private Weapon weaponType;

    /**
     * Тип оружия ближнего боя.
     */
    private MeleeWeapon meleeWeapon;

    /**
     * Корабль.
     */
    private Long starShipId;

}
