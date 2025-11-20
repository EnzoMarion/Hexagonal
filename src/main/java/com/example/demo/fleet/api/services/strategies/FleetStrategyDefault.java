package com.example.demo.fleet.api.services.strategies;

import com.example.demo.fleet.api.models.Mission;
import com.example.demo.fleet.api.models.entities.Starship;
import com.example.demo.fleet.api.repositories.StarshipRepository;
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
