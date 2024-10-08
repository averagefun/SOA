package ru.ifmo.route.converter;

import javax.ejb.Stateless;

import ru.ifmo.core.Coordinates;
import ru.ifmo.core.SpaceMarine;
import ru.ifmo.core.SpaceMarineCreateRequest;
import ru.ifmo.core.SpaceMarineResponse;
import ru.ifmo.core.SpaceMarineUpdateRequest;
import ru.ifmo.core.StarShip;
import ru.ifmo.core.StarShipDto;

@Stateless
public class SpaceMarineConverter {
    public SpaceMarineResponse entityToResponse(SpaceMarine spaceMarine, SpaceMarineResponse response){
        response.setId(spaceMarine.getId());
        response.setName(spaceMarine.getName());
        response.setCoordinates(new Coordinates(spaceMarine.getCoordinateX(), spaceMarine.getCoordinateY().doubleValue()));
        response.setHealth(spaceMarine.getHealth());
        response.setCategory(spaceMarine.getCategory());
        response.setCreationDate(spaceMarine.getCreationDate());
        response.setWeaponType(spaceMarine.getWeaponType());
        response.setMeleeWeapon(spaceMarine.getMeleeWeapon());
        if (spaceMarine.getStarShip() != null)
            response.setStarShipId(spaceMarine.getStarShip().getId());
        return response;
    }

    public SpaceMarine createRequestToEntity(SpaceMarineCreateRequest request, SpaceMarine spaceMarine){
        spaceMarine.setName(request.getName());
        spaceMarine.setCoordinateX(request.getCoordinates().getX());
        spaceMarine.setCoordinateY(request.getCoordinates().getY().longValue());
        spaceMarine.setHealth(request.getHealth());
        spaceMarine.setCategory(request.getCategory());
        spaceMarine.setWeaponType(request.getWeaponType());
        spaceMarine.setMeleeWeapon(request.getMeleeWeapon());
        return spaceMarine;
    }

    public SpaceMarine updateRequestToEntity(SpaceMarineUpdateRequest request, SpaceMarine spaceMarine){
        spaceMarine.setName(request.getName());
        spaceMarine.setCoordinateX(request.getCoordinates().getX());
        spaceMarine.setCoordinateY(request.getCoordinates().getY().longValue());
        spaceMarine.setHealth(request.getHealth());
        spaceMarine.setCategory(request.getCategory());
        spaceMarine.setWeaponType(request.getWeaponType());
        spaceMarine.setMeleeWeapon(request.getMeleeWeapon());
        if (request.getStarShip() != null)
            spaceMarine.setStarShip(starShipEntityFromDto(request.getStarShip()));
        else spaceMarine.setStarShip(null);
        return spaceMarine;
    }

    public StarShip starShipEntityFromDto(StarShipDto dto){
        StarShip starShip = new StarShip();
        starShip.setId(dto.getId());
        starShip.setCoordinateX(dto.getCoordinates().getX());
        starShip.setCoordinateY(dto.getCoordinates().getY().longValue());
        starShip.setFleet(dto.getFleet());
        starShip.setName(dto.getName());
        return starShip;
    }
}
