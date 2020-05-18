package com.ynz.appcontext;

import com.ynz.appcontext.config.ApplicationConfig;
import com.ynz.appcontext.service.OutputService;
import com.ynz.appcontext.service.ProfileManger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * A Spring context encapsulates a Bean factory, which is configured by a java config to determine which beans
 * need to be created, or it may be determined by a component scan and auto-configuration. The application context
 * works as an IOC container, from which the client code acquire the bean at the point it needs.
 */

public class Application {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);

        Stream.of(context.getBean(ProfileManger.class).getCurrentProfile())
                .forEach(s -> System.out.println("current profile: " + s));

        for (int i = 0; i < 5; i++) {
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}
