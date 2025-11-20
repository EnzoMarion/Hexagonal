package com.example.demo.fleet.application.configuration;

import com.example.demo.fleet.domain.services.FleetService;
import com.example.demo.fleet.domain.ports.StarshipPort;
import com.example.demo.fleet.infrastructure.repositories.StarshipRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FleetConfig {

    @Bean
    public FleetService fleetService(StarshipRepository starshipRepository) {
        return new FleetService(starshipRepository); // repo = implémentation du port
    }
}
