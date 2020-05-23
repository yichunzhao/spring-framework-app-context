package com.ynz.appcontext.service;

import com.ynz.appcontext.aspect.Countable;
import com.ynz.appcontext.aspect.Loggable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    //@Value annotation can be placed on fields, methods, and method/constructor
    //parameters to specify a default value.
    @Value("${app.greeting}")
    private String greeting;

    @Value("${app.name}")
    private String name;

    public GreetingService() {
        super();
    }

    @Loggable
    @Countable
    public String getGreeting() {
        return greeting + " " + name;
    }
}
