package com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.stereotype.Component;

@Component
public class PrintLowerCaseImpl {

    @Bean
    public IntegrationFlow printLower() {

        System.out.println("Printing from PrintLowerCaseImpl.printLower()- ");

        return IntegrationFlows
                .from("performLowerCasePrint.input")
                .split()
                .<String, String>transform(String::toLowerCase)
                .aggregate()
                .get();
    }
}
