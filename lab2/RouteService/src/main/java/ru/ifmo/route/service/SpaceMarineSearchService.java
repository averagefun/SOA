package ru.ifmo.route.service;

import javax.ejb.Local;

import ru.ifmo.core.SpaceMarineFilterRequest;
import ru.ifmo.core.SpaceMarineSearchResponse;

@Local
public interface SpaceMarineSearchService {
    SpaceMarineSearchResponse findAllSpaceMarineByFilter(SpaceMarineFilterRequest request);

    SpaceMarineSearchResponse findAllSpaceMarineByName(SpaceMarineFilterRequest request);

    SpaceMarineSearchResponse findAllSpaceMarineWithHealthGreaterThan(SpaceMarineFilterRequest request);
}
