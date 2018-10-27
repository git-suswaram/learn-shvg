package com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.stereotype.Component;

@Component
public class PrintDefaultImpl {

    @Bean
    public IntegrationFlow print() {
        System.out.println("Printing from PrintDefaultImpl.print()- ");
        return IntegrationFlows
                .from("performPrint.input")
                .transform(String::toString)
                .get();
    }

    @Bean
    public IntegrationFlow listPrint() {
        System.out.println("Printing from PrintDefaultImpl.listPrint()- ");
        return IntegrationFlows
                .from("performListPrint.input")
                .split()
                .transform(String::toString)
                .aggregate()
                .get();
    }
}
