package com.ynz.appcontext.service;

public class OutputService {

    private final GreetingService greetingService;
    private final TimeService timeService;

    private final String name;

    public OutputService(GreetingService greetingService, TimeService timeService, String name) {
        this.greetingService = greetingService;
        this.timeService = timeService;
        this.name = name;
    }

    public void generateOutput() {
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }

}
