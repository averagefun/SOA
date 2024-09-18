package ru.ifmo.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель координат.
 *
 * @author Andreey Barabanshchikov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Coordinates {

    /**
     * Координата X.
     */
    private Integer x;

    /**
     * Координата Y.
     */
    private Long y;

}
