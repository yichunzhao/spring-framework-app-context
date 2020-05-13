package com.ynz.appcontext.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {

    private static final DateTimeFormatter FORMATTER_24 = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_12 = DateTimeFormatter.ofPattern("hh:mm:ss a");

    //using Spring expression language to translate the environment that we are in, the profile that we want, into
    //a boolean. # means using Spring Expression Language.
    //the environment includes, the system OS env. var.,  the VM variables or the VM var. and vm arguments,
    // the application arguments as well as as any configuration that you have loaded.
    @Value("#{new Boolean(environment['spring.profiles.active']!='dev')}")
    private boolean is24;

    public TimeService() {
    }

    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        if (is24) {
            return FORMATTER_24.format(now);
        }
        return FORMATTER_12.format(now);
    }

}
