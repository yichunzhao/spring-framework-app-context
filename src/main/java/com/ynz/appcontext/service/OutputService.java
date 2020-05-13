package com.ynz.appcontext.service;

import org.springframework.stereotype.Service;

@Service
public class OutputService {

    private final GreetingService greetingService;
    private final TimeService timeService;

    public OutputService(GreetingService greetingService, TimeService timeService) {
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    public void generateOutput() {
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting();
        System.out.println(output);
    }

}
