package ru.ifmo.core;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель ответа на search запрос.
 *
 * @author Andreey Barabanshchikov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SpaceMarineSearchResponse {

    /**
     * Список найденных космодесантников.
     */
    List<SpaceMarineResponse> items;
    Long pageNumber;

}
