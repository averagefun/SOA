package ru.ifmo.route.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ru.ifmo.core.SpaceMarineFilterRequest;
import ru.ifmo.route.service.SpaceMarineSearchService;

@Path("/spacemarines/search")
public class SpaceMarineSearchResource {
    @Inject
    private SpaceMarineSearchService searchService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response filterSpaceMarine(SpaceMarineFilterRequest request) {
        return Response.ok().entity(searchService.findAllSpaceMarineByFilter(request)).build();
    }

    @POST
    @Path("/name")
    @Produces("application/json")
    public Response getSpaceMarinesByName(SpaceMarineFilterRequest request) {
        return Response.ok().entity(searchService.findAllSpaceMarineByName(request)).build();
    }

    @POST
    @Path("/health/greater")
    @Produces("application/json")
    public Response getSpaceMarinesWithHealthGreaterThan(SpaceMarineFilterRequest request) {
        return Response.ok().entity(searchService.findAllSpaceMarineWithHealthGreaterThan(request)).build();
    }
}
