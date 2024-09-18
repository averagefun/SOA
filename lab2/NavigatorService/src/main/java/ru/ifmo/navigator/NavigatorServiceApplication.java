package ru.ifmo.navigator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Main-класс второго сервиса.
 *
 * @author Andreey Barabanshchikov.
 */
@EnableFeignClients
@SpringBootApplication
@EntityScan("ru.ifmo.core")
public class NavigatorServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NavigatorServiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(NavigatorServiceApplication.class, args);
    }
}
