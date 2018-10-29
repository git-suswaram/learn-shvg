package com.shvg.spring.springboot.restapiwithjpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldResource {

    private final MessageSource messageSource;

    @Autowired
    public HelloWorldResource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        //Create localeResolver using AcceptHeaderLocaleResolver
        return messageSource.getMessage("good.morning.message", null,
                LocaleContextHolder.getLocale());
    }

    @GetMapping("/helloworld-intl")
    public String helloWorldIntl(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        //Create localeResolver using SessionLocaleResolver
        return messageSource.getMessage("good.morning.message", null, locale);
    }

}
