package ru.ifmo.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель ошибки.
 *
 * @author Andreey Barabanshchikov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ErrorResponse {

    /**
     * Код ошибки.
     */
    private Integer code;

    /**
     * Сообщение об ошибке.
     */
    private String message;

}
