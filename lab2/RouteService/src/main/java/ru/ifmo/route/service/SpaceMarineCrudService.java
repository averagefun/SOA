package ru.ifmo.route.service;

import javax.ejb.Local;

import ru.ifmo.core.PageDto;
import ru.ifmo.core.SpaceMarineCreateRequest;
import ru.ifmo.core.SpaceMarineResponse;
import ru.ifmo.core.SpaceMarineSearchResponse;
import ru.ifmo.core.SpaceMarineUpdateRequest;

@Local
public interface SpaceMarineCrudService {
    void createSpaceMarine(SpaceMarineCreateRequest request);

    void updateSpaceMarine(Long id, SpaceMarineUpdateRequest request);

    SpaceMarineSearchResponse getAllSpaceMarines(PageDto pageDto);

    SpaceMarineResponse getSpaceMarineById(Long id);

    void deleteSpaceMarine(Long id);
}
