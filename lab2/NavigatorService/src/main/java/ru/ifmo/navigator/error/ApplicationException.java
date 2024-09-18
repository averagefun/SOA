package ru.ifmo.navigator.error;

import lombok.Getter;
import ru.ifmo.core.ErrorResponse;

/**
 * Кастомные исключения.
 *
 * @author Andreey Barabanshchikov.
 */
@Getter
public class ApplicationException extends RuntimeException {

    /**
     * {@link ErrorResponse}, ошибка, возвращаемая на фронт.
     */
    private final ErrorResponse errorResponse;

    public ApplicationException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }

}
