package com.shvg.spring.springboot.springintegration.annotation.processEndpoints.serviceActivator;

import com.shvg.spring.springboot.springintegration.annotation.processEndpoints.serviceActivator.data.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.http.dsl.Http;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;
import org.springframework.integration.mapping.HeaderMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("local")
public class PrintUpperCasePersonImpl {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${services.tracking.timeout}")
    private int timeout;

    @Value("${services.tracking.url}")
    private String url;

    public static Logger logger = LoggerFactory.getLogger(PrintUpperCasePersonImpl.class);


    @Bean
    public IntegrationFlow execute(List<Person> persons) {

        return IntegrationFlows
                .from("performPrint.input")
                .enrichHeaders(h->h
                        .headerFunction("messageHeader", e->e.getPayload().toString(),true)
                        .header("name","Sreedhar"))
                .split()
                .transform(p -> getFullName(p))
                .transform(Transformers.toJson(MediaType.APPLICATION_JSON_VALUE))
                .aggregate()
                .handle(Http
                        .outboundGateway(url)
                        .requestFactory(getRequestFactory())
                        .headerMapper(headerMapper())
                        .httpMethod(HttpMethod.GET)
                        .extractPayload(true))
                .log("\nAfter Handle")
                .get();
    }

    @Bean
    public IntegrationFlow getPrintEnrichService(){

        return IntegrationFlows
                .from("getPrintEnrichChannel")
                .enrichHeaders(h->h.header("PrintEnrichServiceHeader","PrintEnrichServiceValue"))
                .get();
    }

    public Object getFullName(Object person) {
        String fullName=new StringBuilder(
                ((Person) person).getLastName())
                .append(" - ")
                .append(((Person) person).getFirstName())
                .toString();
        ((Person)person).setFullName(fullName);

        return person;
    }

    @Bean
    public SimpleClientHttpRequestFactory getRequestFactory(){

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(Integer.valueOf(timeout));
        factory.setReadTimeout(Integer.valueOf(timeout));

        return factory;
    }

    @Bean
    public HeaderMapper headerMapper(){
        DefaultHttpHeaderMapper headerMapper = new DefaultHttpHeaderMapper();
        headerMapper.setUserDefinedHeaderPrefix("");
        headerMapper.setOutboundHeaderNames(new String[]{"*"});
        return headerMapper;
    }
}
