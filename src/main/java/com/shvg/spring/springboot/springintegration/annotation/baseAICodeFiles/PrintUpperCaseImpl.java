package com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.stereotype.Component;

@Component
public class PrintUpperCaseImpl {

    @Bean
    public IntegrationFlow printUpper() {

        System.out.println("Printing from PrintUpperCaseImpl.printUpper()- ");

        return IntegrationFlows
                .from("performUpperCasePrint.input")
                .split()
                .<String, String>transform(String::toUpperCase)
                .aggregate()
                .get();
    }
}
