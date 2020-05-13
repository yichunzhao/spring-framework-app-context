package com.ynz.appcontext.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ProfileManger {

    private Environment environment;

    public ProfileManger(Environment environment) {
        this.environment = environment;
    }

    public String[] getCurrentProfile() {
        return environment.getActiveProfiles();
    }
}
