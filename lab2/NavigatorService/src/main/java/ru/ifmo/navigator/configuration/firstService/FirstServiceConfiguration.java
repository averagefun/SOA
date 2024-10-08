package ru.ifmo.navigator.configuration.firstService;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Client;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.ifmo.navigator.configuration.FeignConfiguration;
import ru.ifmo.navigator.configuration.RestTemplateConfiguration;
import ru.ifmo.navigator.error.handler.ErrorHandler;
import ru.ifmo.navigator.integration.FirstService;

/**
 * Конфигурация подключения к первому сервису.
 *
 * @author Andreey Barabanshchikov.
 */
@Configuration
@RequiredArgsConstructor
@Import({RestTemplateConfiguration.class, FeignConfiguration.class})
public class FirstServiceConfiguration {

    /**
     * {@link FirstServiceConfigurationProperties}.
     */
    private final FirstServiceConfigurationProperties properties;

    /**
     * Кодировщик.
     */
    private final Encoder encoder;

    /**
     * Дешифратор.
     */
    private final Decoder decoder;

    /**
     * Ошибка кодировки.
     */
    private final ErrorDecoder errorDecoder;

    /**
     * {@link Client}.
     */
    private final Client client;

    /**
     * Шаблон обслуживания.
     *
     * @param objectMapper {@link ObjectMapper}.
     * @param errorHandler {@link ErrorHandler}.
     * @return {@link RestTemplate}.
     */
    @Bean
    @Qualifier("FirstServiceRestTemplate")
    @ConditionalOnMissingBean(name = "FirstServiceRestTemplate")
    public RestTemplate firstServiceRestTemplate(ObjectMapper objectMapper, @Qualifier("serviceErrorHandler")
    ErrorHandler errorHandler) {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(properties.getTimeout());
        clientHttpRequestFactory.setReadTimeout(properties.getTimeout());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(properties.getUrl()));
        restTemplate.getMessageConverters().stream()
                .filter(it -> it instanceof MappingJackson2HttpMessageConverter)
                .map(it -> (MappingJackson2HttpMessageConverter) it)
                .forEach(it -> it.setObjectMapper(objectMapper));
        restTemplate.setErrorHandler(errorHandler);
        return restTemplate;
    }

    @Bean
    public FirstService firstService() {
        return Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(errorDecoder)
                .contract(new SpringMvcContract())
                .target(FirstService.class, properties.getUrl());
    }

}
