
package com.shvg.spring.springboot.basicspringbootapplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/*
@SpringBootApplication annotation automatically scans for beans in package and subpackages where SpringBootApplication is in.
Otherwise use below syntax

@SpringBootApplication(scanBasePackages="com")
*/

/*@PropertySources({
        @PropertySource("classpath:/application_${ENV_NAME:default}.properties")
})*/
@SpringBootApplication
@Configuration

public class BaseSpringBootApplication {

    @Value("${ENV_NAME:local}")
    private String env;

    public static void main(String[] args) {

        //Read configuration from spring-springintegration-local.yaml file
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(BaseSpringBootApplication.class)
                .properties("spring.config.name=spring-config-file-${ENV_NAME:local}," +
                        "can-add-comma-separated-config-file-list")
                .run(args);


        ctx.close();
    }
}
