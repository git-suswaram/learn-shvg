
package com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

import java.util.Collection;

import static com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles.data.Data.listOfPersons;
import static com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles.data.Data.listOfStrings;


@SpringBootApplication
/*@SpringBootApplication(scanBasePackages="com")*/
/*@PropertySources({
        @PropertySource("classpath:/application_${ENV_NAME:default}.properties")
})*/
@EnableIntegration
@IntegrationComponentScan
@Configuration

public class BaseSpringIntegrationApplication {

    @Value("${ENV_NAME:local}")
    private String env;

    public static void main(String[] args) {

         /*
        //Read configuration from application.properties
        ConfigurableApplicationContext ctx =
                SpringApplication.run(LearnShvgApplication.class, args);
        */

        //Read configuration from spring-springintegration-local.yaml file
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(BaseSpringIntegrationApplication.class)
                .properties("spring.config.name=spring-springintegration-${ENV_NAME:local}," +
                        "can-add-comma-separated-config-file-list")
                .run(args);

        Collection<String> stringCollection
                = ctx.getBean(PrintGateway.class).printLower(listOfStrings);
        System.out.println(stringCollection.toString());

        Collection<String> stringCollection2
                = ctx.getBean(PrintGateway.class).execute(listOfPersons);
        System.out.println(stringCollection2.toString());

        ctx.close();
    }
}
