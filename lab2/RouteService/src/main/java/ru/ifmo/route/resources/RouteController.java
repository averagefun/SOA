package ru.ifmo.route.resources;

import ru.ifmo.core.Route;
import ru.ifmo.route.repository.RouteRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@Path("/routes")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
@RequestScoped
public class RouteController {

    @Inject
    private RouteRepository routeRepository;

    // Получить список всех маршрутов
    @GET
    public Response getAllRoutes(
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size,
            @QueryParam("sort") String sort,
            @QueryParam("filter") String filter,
            @QueryParam("name") String name) {
        try {
            List<Route> routes = routeRepository.findAll(page, size, sort, filter, name);
            GenericEntity<List<Route>> entity = new GenericEntity<List<Route>>(routes) {};
            return Response.ok(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ошибка сервера: " + e.getMessage())
                    .build();
        }
    }

    // Добавить новый маршрут
    @POST
    public Response createRoute(Route route, @Context UriInfo uriInfo) {
        try {
            routeRepository.save(route);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(Integer.toString(route.getId()));
            return Response.created(builder.build()).entity(route).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Ошибка валидации данных: " + e.getMessage())
                    .build();
        }
    }

    // Получить маршрут по ID
    @GET
    @Path("/{id}")
    public Response getRouteById(@PathParam("id") int id) {
        Route route = routeRepository.findById(id);
        if (route != null) {
            return Response.ok(route).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Маршрут не найден")
                    .build();
        }
    }

    // Обновить маршрут по ID
    @PUT
    @Path("/{id}")
    public Response updateRoute(@PathParam("id") int id, Route route) {
        try {
            Route existingRoute = routeRepository.findById(id);
            if (existingRoute == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Маршрут не найден")
                        .build();
            }
            route.setId(id);
            routeRepository.update(route);
            return Response.ok(route).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Ошибка валидации данных: " + e.getMessage())
                    .build();
        }
    }

    // Удалить маршрут по ID
    @DELETE
    @Path("/{id}")
    public Response deleteRoute(@PathParam("id") int id) {
        try {
            routeRepository.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Маршрут не найден")
                    .build();
        }
    }

    // Найти маршруты по подстроке в поле name
    @GET
    @Path("/name/{value}")
    public Response findRoutesByName(@PathParam("value") String value) {
        try {
            List<Route> routes = routeRepository.findByNameContaining(value);
            if (routes.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Маршруты не найдены")
                        .build();
            }
            GenericEntity<List<Route>> entity = new GenericEntity<List<Route>>(routes) {};
            return Response.ok(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ошибка сервера: " + e.getMessage())
                    .build();
        }
    }

    // Получить маршрут с максимальным значением поля from
    @GET
    @Path("/from/max")
    public Response getRouteWithMaxFrom() {
        try {
            Route route = routeRepository.findRouteWithMaxFrom();
            return Response.ok(route).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ошибка сервера: " + e.getMessage())
                    .build();
        }
    }

    // Получить количество маршрутов с distance меньше заданного
    @GET
    @Path("/distance/lower/{value}/count")
    public Response countRoutesWithDistanceLowerThan(@PathParam("value") int value) {
        try {
            Long count = routeRepository.countByDistanceLessThan(value);
            return Response.ok(count.toString()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ошибка сервера: " + e.getMessage())
                    .build();
        }
    }
}
