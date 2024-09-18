package ru.ifmo.route.service;

import javax.ejb.Local;

import ru.ifmo.core.MeleeWeaponGroupResponse;

@Local
public interface SpaceMarineGroupService {
    MeleeWeaponGroupResponse groupSpaceMarinesByMeleeWeaponAndCount();
}
