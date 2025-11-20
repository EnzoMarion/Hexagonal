package com.example.demo.fleet.api.controllers;

import com.example.demo.fleet.api.controllers.configuration.Settings;
import com.example.demo.fleet.api.utils.Parsing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Settings settings;

    @GetMapping("/")
    public String get() {
        return settings.getVersion() + " - " + settings.getAuthor();
    }
    @GetMapping("/test")
    public String testEndpoint() {
        return Parsing.getEndpoint("https://swapi.dev/api", "https://swapi.dev/api/starships/?page=2");
    }
}
