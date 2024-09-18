package ru.ifmo.navigator.configuration.firstService;

import javax.annotation.PostConstruct;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * Настройки подключения к первому сервису.
 *
 * @author Andreey Barabanshchikov.
 */
@Data
@Slf4j
@Validated
@Configuration
@EnableConfigurationProperties
public class FirstServiceConfigurationProperties {

    /**
     * Адрес сервиса опросов.
     */
    @Value("${service.first-service.url}")
    private String url;

    /**
     * Таймаут.
     */
    @Value("${service.first-service.timeout}")

    private Integer timeout;

    /**
     * Инициализация
     */
    @PostConstruct
    public void postConstruct() {
        log.info(" ::: {} initialized :::\n\t\turl: {}\n\t\ttimeout : {}", this.getClass().getSimpleName(), url,
                timeout);
    }

}
