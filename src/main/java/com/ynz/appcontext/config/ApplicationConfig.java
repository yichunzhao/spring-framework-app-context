package com.ynz.appcontext.config;


import com.ynz.appcontext.service.GreetingService;
import com.ynz.appcontext.service.OutputService;
import com.ynz.appcontext.service.TimeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    //@Value annotation can be placed on fields, methods, and method/constructor parameters to specify a
    //default value.
    @Value("${app.greeting}")
    private String greeting;

    @Value("${app.name}")
    private String name;

    //using Spring expression language to translate the environment that we are in, the profile that we want, into
    //a boolean. # means using Spring Expression Language.
    //the environment includes, the system OS env. var.,  the VM variables or the VM var. and vm arguments,
    // the application arguments as well as as any configuration that you have loaded.
    @Value("#{new Boolean(environment['spring.profiles.active']!='dev')}")
    private boolean is24;

    @Bean
    public TimeService timeService() {
        return new TimeService(is24);
    }

//    @Bean
//    @Profile("!dev")
//    public TimeService timeService() {
//        return new TimeService(true);
//    }
//
//    @Bean
//    @Profile("dev")
//    public TimeService timeService12() {
//        return new TimeService(false);
//    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService(greeting);
    }

    //if there is only one instance of a bean type, then it can injected successfully by type without ambiguity.
    @Bean
    public OutputService outputService(GreetingService greetingService, TimeService timeService) {
        return new OutputService(greetingService, timeService, name);
    }


}
