package com.example.demo.fleet.domain.services.strategies;

import com.example.demo.fleet.domain.models.Mission;
import com.example.demo.fleet.domain.models.entities.Starship;
import com.example.demo.fleet.domain.models.enums.StarshipType;
import com.example.demo.fleet.infrastructure.repositories.StarshipRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FleetStrategyMaxSpeed implements FleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return mission.getMeans() != null &&
                mission.getMeans().toUpperCase().contains("FAST");
    }

    @Override
    public List<Starship> assign(StarshipRepository repository, Mission mission) {
        return repository.findAll().stream()
                .filter(s -> s.getCategory() == StarshipType.FIGHTER)
                .collect(Collectors.toList());
    }
}
