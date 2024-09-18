package ru.ifmo.navigator.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ifmo.core.StarShip;

/**
 * Репозиторий доступа к сущности {@link StarShip}.
 *
 * @author Andreey Barabanshchikov.
 */
public interface StarshipRepository extends JpaRepository<StarShip, Long> {

}
