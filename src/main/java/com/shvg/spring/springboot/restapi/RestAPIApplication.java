
package com.shvg.spring.springboot.restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;


@SpringBootApplication
@Configuration
public class RestAPIApplication {

    private static Logger logger = LoggerFactory.getLogger(RestAPIApplication.class);

    @Value("${ENV_NAME:local}")
    private String env;


    public static void main(String[] args) {

        //Get Spring Application Context and rest configurations from spring-rest-api-local.yaml file
        new SpringApplicationBuilder(RestAPIApplication.class)
                .properties("spring.config.name=spring-rest-api-${ENV_NAME:local}")
                .run(args);
    }

    @Bean
    public LocaleResolver sessionLocaleResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);

        return localeResolver;
    }

    @Bean
    public LocaleResolver acceptHeaderLocaleResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }
}
