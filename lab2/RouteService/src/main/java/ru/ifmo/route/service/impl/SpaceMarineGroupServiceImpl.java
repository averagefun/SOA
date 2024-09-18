package ru.ifmo.route.service.impl;

import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ru.ifmo.core.MeleeWeaponGroupResponse;
import ru.ifmo.core.enums.MeleeWeapon;
import ru.ifmo.route.repository.SpaceMarineGroupRepository;
import ru.ifmo.route.service.SpaceMarineGroupService;

@Stateless
public class SpaceMarineGroupServiceImpl implements SpaceMarineGroupService {

    @Inject
    private SpaceMarineGroupRepository repository;

    @Override
    public MeleeWeaponGroupResponse groupSpaceMarinesByMeleeWeaponAndCount() {
        Map<MeleeWeapon, Long> meleeToAmount = repository.groupByMeleeAndCount();
        return MeleeWeaponGroupResponse.of(
                meleeToAmount.get(MeleeWeapon.CHAIN_AXE),
                meleeToAmount.get(MeleeWeapon.CHAIN_SWORD),
                meleeToAmount.get(MeleeWeapon.POWER_FIST));
    }
}
