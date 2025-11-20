package com.example.demo.fleet.domain.services.strategies;

import com.example.demo.fleet.domain.models.Mission;
import com.example.demo.fleet.domain.models.entities.Starship;
import com.example.demo.fleet.infrastructure.repositories.StarshipRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FleetStrategyDefault implements FleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return true;
    }

    @Override
    public List<Starship> assign(StarshipRepository repository, Mission mission) {
        return repository.findAll();
    }
}
