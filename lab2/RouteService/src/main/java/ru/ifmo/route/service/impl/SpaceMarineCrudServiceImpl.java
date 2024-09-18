package ru.ifmo.route.service.impl;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import ru.ifmo.core.PageDto;
import ru.ifmo.core.SpaceMarine;
import ru.ifmo.core.SpaceMarineCreateRequest;
import ru.ifmo.core.SpaceMarineResponse;
import ru.ifmo.core.SpaceMarineSearchResponse;
import ru.ifmo.core.SpaceMarineUpdateRequest;
import ru.ifmo.route.converter.SpaceMarineConverter;
import ru.ifmo.route.repository.SpaceMarineCrudRepository;
import ru.ifmo.route.service.SpaceMarineCrudService;

@Stateless
public class SpaceMarineCrudServiceImpl implements SpaceMarineCrudService {
    @Inject
    private SpaceMarineCrudRepository repository;
    @Inject
    private SpaceMarineConverter converter;

    @Override
    public void createSpaceMarine(SpaceMarineCreateRequest request) {
        SpaceMarine spaceMarine = new SpaceMarine();
        ZonedDateTime time = ZonedDateTime.now();
        spaceMarine.setCreationDate(time.with(LocalTime.of(0,0,0,0)));
        repository.save(converter.createRequestToEntity(request, spaceMarine));
    }

    @Override
    public void updateSpaceMarine(Long id, SpaceMarineUpdateRequest request) {
        SpaceMarine spaceMarine = repository.getById(id);
        if (spaceMarine == null) throw new NotFoundException();
        repository.save(converter.updateRequestToEntity(request, spaceMarine));
    }

    @Override
    public SpaceMarineSearchResponse getAllSpaceMarines(PageDto pageDto) {
        List<SpaceMarine> marines = repository.getAllPageable(pageDto.getPage(), pageDto.getLimit());
        List<SpaceMarineResponse> responseList = new ArrayList<>();
        for (SpaceMarine marine : marines) {
            SpaceMarineResponse response = new SpaceMarineResponse();
            responseList.add(converter.entityToResponse(marine, response));
        }
        return SpaceMarineSearchResponse.of(responseList, countPages(pageDto.getLimit()));
    }

    @Override
    public SpaceMarineResponse getSpaceMarineById(Long id) {
        SpaceMarine spaceMarine = repository.getById(id);
        SpaceMarineResponse response = new SpaceMarineResponse();
        return converter.entityToResponse(spaceMarine, response);
    }

    @Override
    public void deleteSpaceMarine(Long id) {
        SpaceMarine spaceMarine = repository.getById(id);
        if (spaceMarine == null) throw new NotFoundException();
        repository.deleteById(id);
    }

    private Long countPages(Integer limit) {
        return Double.valueOf(Math.ceil(repository.countMarines().floatValue() / limit.floatValue())).longValue();
    }
}
