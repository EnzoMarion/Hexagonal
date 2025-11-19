package com.example.demo.fleet.api.controllers;

import com.example.demo.fleet.api.controllers.configuration.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Settings settings;

    @GetMapping("/")
    public String get() {
        return settings.getVersion();
    }
}
