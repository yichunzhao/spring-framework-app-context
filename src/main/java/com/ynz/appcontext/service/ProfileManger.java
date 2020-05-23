package com.ynz.appcontext.service;

import com.ynz.appcontext.aspect.Countable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ProfileManger {

    private Environment environment;

    public ProfileManger(Environment environment) {
        this.environment = environment;
    }

    @Countable
    public String[] getCurrentProfile() {
        return environment.getActiveProfiles();
    }
}
