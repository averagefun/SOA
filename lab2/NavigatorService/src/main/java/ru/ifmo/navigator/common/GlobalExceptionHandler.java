package ru.ifmo.navigator.common;

import javax.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import ru.ifmo.core.ErrorResponse;
import ru.ifmo.navigator.error.ApplicationException;
import ru.ifmo.navigator.error.ErrorDescriptions;

/**
 * {@link ControllerAdvice}, обрабатывающий возникающие исключения.
 *
 * @author Andreey Barabanshchikov.
 */
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    /**
     * Обработка исключения {@link NoHandlerFoundException}.
     *
     * @param ex исключение.
     * @return ошибка приложения.
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ErrorResponse handleError404(NoHandlerFoundException ex) {
        return ErrorDescriptions.HANDLER_NOT_FOUND.applicationError();
    }

    /**
     * Обработка бизнес исключений.
     *
     * @param ex исключение.
     * @return ошибка приложения.
     */
    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public ErrorResponse handleApplicationException(ApplicationException ex, HttpServletResponse response) {
        response.setStatus(ex.getErrorResponse().getCode());
        log.debug("Exception happened {}", ex.getMessage());
        return ex.getErrorResponse();
    }

}
