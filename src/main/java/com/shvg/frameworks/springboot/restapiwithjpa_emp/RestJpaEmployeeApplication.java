
package com.shvg.frameworks.springboot.restapiwithjpa_emp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication(
        scanBasePackages = {"com.shvg.frameworks.springboot.basedata", "com.shvg.frameworks.springboot.restapiwithjpa"})
@EntityScan("com.shvg.frameworks.springboot.restapiwithjpa_emp.entity")
@Configuration

/*@PropertySources({
        @PropertySource("classpath:/application_${ENV_NAME:default}.properties")
})*/
public class RestJpaEmployeeApplication {

    @Value("${ENV_NAME:local}")
    private String env;

    private static Logger logger = LoggerFactory.getLogger(RestJpaEmployeeApplication.class);

    public static void main(String[] args) {

        logger.info("Starting Application");

        //Get Spring Application Context and rest configurations from frameworks-rest-api-local.yaml file
        new SpringApplicationBuilder(RestJpaEmployeeApplication.class)
                .properties("frameworks.config.name=frameworks-rest-api-with-jpa-${ENV_NAME:local}")
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
