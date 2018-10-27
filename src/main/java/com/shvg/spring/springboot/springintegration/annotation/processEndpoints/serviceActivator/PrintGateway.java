package com.shvg.spring.springboot.springintegration.annotation.processEndpoints.serviceActivator;


import com.shvg.spring.springboot.springintegration.annotation.processEndpoints.serviceActivator.data.Person;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@MessagingGateway
public interface PrintGateway {

	@Gateway(requestChannel = "performPrint.input")
	Collection<String> execute(List<Person> persons);


}
