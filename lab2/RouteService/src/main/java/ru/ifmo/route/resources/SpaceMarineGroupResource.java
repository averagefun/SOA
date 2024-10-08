package ru.ifmo.route.resources;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ru.ifmo.route.service.SpaceMarineGroupService;

@Path("/spacemarines/group")
public class SpaceMarineGroupResource {
    @Inject
    private SpaceMarineGroupService groupService;

    @POST
    @Path("/melee")
    @Produces("application/json")
    public Response getNumberOfSpaceMarinesWithEachMeleeType() {
        return Response.ok().entity(groupService.groupSpaceMarinesByMeleeWeaponAndCount()).build();
    }
}
