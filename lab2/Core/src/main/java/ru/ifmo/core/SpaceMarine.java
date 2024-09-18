package ru.ifmo.core;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import ru.ifmo.core.enums.AstartesCategory;
import ru.ifmo.core.enums.MeleeWeapon;
import ru.ifmo.core.enums.Weapon;

/**
 * Сущность Space Marine.
 *
 * @author Andreey Barabanshchikov.
 */
@Getter
@Setter
@Entity
@Table(name = "spacemarine")
public class SpaceMarine {

    /**
     * Идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", allocationSize = 1, sequenceName = "spacemarine_seq")
    private Long id;

    /**
     * Имя.
     */
    @Column(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой

    /**
     * Координата X.
     */
    @Column(name = "coordinate_x")
    private Integer coordinateX; //Значение поля должно быть больше -754, Поле не может быть null

    /**
     * Координата Y.
     */
    @Column(name = "coordinate_y")
    private Long coordinateY;

    /**
     * Дата создания.
     */
    @Column(name = "creation_date")
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    /**
     * Количество здоровья.
     */
    @Column(name = "health")
    private Long health; //Значение поля должно быть больше 0

    /**
     * Класс персонажа.
     */
    @Column(name = "astartes_category")
    @Enumerated(EnumType.ORDINAL)
    private AstartesCategory category; //Поле не может быть null

    /**
     * Тип оружия.
     */
    @Column(name = "weapon_type")
    @Enumerated(EnumType.ORDINAL)
    private Weapon weaponType; //Поле не может быть null

    /**
     * Тип оружия ближнего боя.
     */
    @Column(name = "melee_weapon")
    @Enumerated(EnumType.ORDINAL)
    private MeleeWeapon meleeWeapon; //Поле может быть null

    /**
     * Корабль.
     */
    @ManyToOne
    @JoinColumn(name = "starship_id")
    private StarShip starShip;
}
