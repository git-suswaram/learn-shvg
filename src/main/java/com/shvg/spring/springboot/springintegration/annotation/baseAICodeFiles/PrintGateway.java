package com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles;

import com.shvg.spring.springboot.springintegration.annotation.baseAICodeFiles.data.Person;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@MessagingGateway
public interface PrintGateway {

    @Gateway(requestChannel = "performPrint.input")
    Collection<String> print(String message);

    @Gateway(requestChannel = "performLowerCasePrint.input")
    Collection<String> printLower(Collection<String> strings);

    @Gateway(requestChannel = "performPrintPerson.input")
    Collection<String> execute(List<Person> persons);

    @Gateway(requestChannel = "performUpperCasePrint.input")
    Collection<String> printUpper(Collection<String> strings);

    @Gateway(requestChannel = "performListPrint.input")
    Collection<String> listPrint(Collection<String> strings);


}
