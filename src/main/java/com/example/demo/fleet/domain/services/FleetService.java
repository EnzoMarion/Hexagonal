package com.example.demo.fleet.domain.services;

import com.example.demo.fleet.domain.ports.StarshipPort;
import com.example.demo.fleet.domain.models.Mission;
import com.example.demo.fleet.domain.models.entities.Starship;
import com.example.demo.fleet.domain.services.strategies.*;
import com.example.demo.fleet.infrastructure.repositories.StarshipRepository;

import java.util.Collections;
import java.util.List;

public class FleetService {

    private final FleetStrategy[] STRATEGIES = {
            new FleetStrategyMinEntropy(),
            new FleetStrategyMinCost(),
            new FleetStrategyMaxSpeed(),
            new FleetStrategyDefault(),
    };

    private final StarshipPort starshipPort;

    public FleetService(StarshipPort starshipPort) {
        this.starshipPort = starshipPort;
    }

    public List<Starship> forMission(Mission mission) {
        for (FleetStrategy strategy : STRATEGIES) {
            if (strategy.match(mission)) {
                return strategy.assign((StarshipRepository) starshipPort, mission);
            }
        }
        return Collections.emptyList();
    }
}
