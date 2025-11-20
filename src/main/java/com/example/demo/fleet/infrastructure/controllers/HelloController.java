package com.example.demo.fleet.infrastructure.controllers;

import com.example.demo.fleet.application.configuration.Settings;
import com.example.demo.fleet.utils.Parsing;
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
    @GetMapping("/testParsing")
    public String testEndpoint() {
        String baseUrl = "https://swapi.dev/api";
        String url1 = "https://swapi.dev/api/starships/?page=2";
        String url2 = "https://www.fake.com/api/starships/?page=2";
        String result1 = Parsing.getEndpoint(baseUrl, url1);
        String result2 = Parsing.getEndpoint(baseUrl, url2);

        return "url1: " + result1 + " url2: " + result2;
    }
}
