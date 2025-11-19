package com.example.demo.fleet.api.controllers.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")

public class Settings {
    private String version;
    private String author;
}
