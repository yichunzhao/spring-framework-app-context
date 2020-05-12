package com.ynz.appcontext;

import com.ynz.appcontext.config.ApplicationConfig;
import com.ynz.appcontext.service.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * A Spring context encapsulates a Bean factory, which is configured by a java config to determine which beans
 * need to be created. The application context works as a IOC container, via which the client code may directly
 * DI the bean in its own usage.
 */

public class Application {

    public static void main(String[] args) throws Exception {
//        GreetingService greetingService = new GreetingService("Hello");
//        TimeService timeService = new TimeService(true);
//        OutputService outputService = new OutputService(greetingService,timeService);

        //Java config tells IOC container what should be instantiated for usage later on. That is almost the first
        //thing to do as the Spring starts. The application context cook beans for clients.

        //Beans can be injected from the application context, i.e. its IOC container.
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);

        for (int i = 0; i < 5; i++) {
            outputService.generateOutput("Somebody");
            Thread.sleep(5000);
        }
    }
}