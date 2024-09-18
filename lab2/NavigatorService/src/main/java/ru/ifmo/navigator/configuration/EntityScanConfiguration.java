package ru.ifmo.navigator.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

/**
 * Подключение сущностей из библиотеки.
 *
 * @author Andreey Barabanshchikov.
 */
@Configuration
@EntityScan("ru.ifmo.se.library")
public class EntityScanConfiguration {
}
