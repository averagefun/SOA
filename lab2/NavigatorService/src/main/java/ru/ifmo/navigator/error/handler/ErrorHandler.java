package ru.ifmo.navigator.error.handler;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import ru.ifmo.core.ErrorResponse;
import ru.ifmo.navigator.error.ApplicationException;

/**
 * Обработчик ошибок из первого сервиса.
 *
 * @author Andreey Barabanshchikov.
 */
@RequiredArgsConstructor
public class ErrorHandler implements ResponseErrorHandler {

    private final ObjectMapper objectMapper;

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return !response.getStatusCode().is2xxSuccessful();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        ErrorResponse error = objectMapper.readValue(response.getBody(), ErrorResponse.class);
        throw new ApplicationException(error);
    }

}
