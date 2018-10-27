
package com.shvg.spring.springboot.springintegration.annotation.processEndpoints.serviceActivator;

import com.shvg.spring.springboot.springintegration.annotation.processEndpoints.serviceActivator.data.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@SpringBootApplication
/*
@SpringBootApplication(scanBasePackages="com")

@PropertySources({
        @PropertySource("classpath:/application_${ENV_NAME:default}.properties")
})

@EnableIntegration
@IntegrationComponentScan
*/
@Configuration

public class ServiceActivatorApplication {

	public static Logger logger = LoggerFactory.getLogger(ServiceActivatorApplication.class);

	@Value("${ENV_NAME:local}")
	private String env;

	public static void main(String[] args) {

        /*
        //Default execution of spring boot application
        ConfigurableApplicationContext ctx =
                SpringApplication.run(AnnotationSpringIntegration.class, args);
        */

		//Read configuration from spring-springintegration-local.yaml file
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(ServiceActivatorApplication.class)
				.properties("spring.config.name=spring-springintegration-${ENV_NAME:local},"+
						"can-add-comma-separated-config-file-list").run(args);

		Collection<String> stringCollection = ctx.getBean(PrintGateway.class).execute(Data.listOfPersons);
		System.out.println(stringCollection);

		ctx.close();
	}
}
