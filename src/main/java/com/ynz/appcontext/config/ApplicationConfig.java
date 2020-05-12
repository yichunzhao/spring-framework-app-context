package com.ynz.appcontext.config;


import com.ynz.appcontext.service.GreetingService;
import com.ynz.appcontext.service.OutputService;
import com.ynz.appcontext.service.TimeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    //@Value annotation can be placed on fields, methods, and method/constructor parameters to specify a
    //default value.
    @Value("hello")
    private String greeting;

    @Bean
    public TimeService timeService() {
        return new TimeService(true);
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService("hello");
    }

    //if there is only one instance of a bean type, then it can injected successfully by type without ambiguity.
    @Bean
    public OutputService outputService(GreetingService greetingService, TimeService timeService) {
        return new OutputService(greetingService, timeService);
    }


}
