package ru.ifmo.route.repository;

import ru.ifmo.core.Route;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import javax.ws.rs.ext.Provider;

@Provider
@RequestScoped
public class RouteRepository {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public List<Route> findAll(int page, int size, String sortField, String filter, String nameFilter) {
        String jpql = "SELECT r FROM Route r";
        String whereClause = "";
        if (nameFilter != null && !nameFilter.isEmpty()) {
            whereClause += " WHERE r.name LIKE :nameFilter";
        }
        if (filter != null && !filter.isEmpty()) {
            // Добавьте дополнительную логику фильтрации по другим полям
        }
        if (!whereClause.isEmpty()) {
            jpql += whereClause;
        }
        if (sortField != null && !sortField.isEmpty()) {
            jpql += " ORDER BY r." + sortField;
        }

        TypedQuery<Route> query = entityManager.createQuery(jpql, Route.class);

        if (nameFilter != null && !nameFilter.isEmpty()) {
            query.setParameter("nameFilter", "%" + nameFilter + "%");
        }

        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);

        return query.getResultList();
    }

    public Route findById(int id) {
        return entityManager.find(Route.class, id);
    }

    public List<Route> findByNameContaining(String value) {
        String jpql = "SELECT r FROM Route r WHERE r.name LIKE :value";
        return entityManager.createQuery(jpql, Route.class)
                .setParameter("value", "%" + value + "%")
                .getResultList();
    }

    @Transactional
    public Route save(Route route) {
        entityManager.persist(route);
        return route;
    }

    @Transactional
    public Route update(Route route) {
        return entityManager.merge(route);
    }

    @Transactional
    public void delete(int id) {
        Route route = findById(id);
        if (route != null) {
            entityManager.remove(route);
        }
    }

    public Route findRouteWithMaxFrom() {
        String jpql = "SELECT r FROM Route r ORDER BY r.from.x DESC";
        return entityManager.createQuery(jpql, Route.class)
                .setMaxResults(1)
                .getSingleResult();
    }

    public Long countByDistanceLessThan(int value) {
        String jpql = "SELECT COUNT(r) FROM Route r WHERE r.distance < :value";
        return entityManager.createQuery(jpql, Long.class)
                .setParameter("value", value)
                .getSingleResult();
    }
}
