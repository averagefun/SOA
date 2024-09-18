package ru.ifmo.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ifmo.core.enums.AstartesCategory;
import ru.ifmo.core.enums.MeleeWeapon;
import ru.ifmo.core.enums.Weapon;

/**
 * Модель запроса на создание Space Marine.
 *
 * @author Andreey Barabanshchikov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SpaceMarineCreateRequest {

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

}
