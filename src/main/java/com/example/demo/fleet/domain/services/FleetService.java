package com.example.demo.fleet.domain.services;

import com.example.demo.fleet.domain.models.Mission;
import com.example.demo.fleet.domain.models.entities.Starship;
import com.example.demo.fleet.infrastructure.repositories.StarshipRepository;
import com.example.demo.fleet.domain.services.strategies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FleetService {

    private final FleetStrategy[] STRATEGIES = {
            new FleetStrategyMinEntropy(),
            new FleetStrategyMinCost(),
            new FleetStrategyMaxSpeed(),
            new FleetStrategyDefault(),
    };

    @Autowired
    private StarshipRepository starships;

    /**
     * Réserve une flotte de vaisseaux avec une stratégie adaptée à la mission
     */
    public List<Starship> forMission(Mission mission) {
        for (FleetStrategy strategy : STRATEGIES) {
            if (strategy.match(mission)) {
                return strategy.assign(starships, mission);
            }
        }

        // Aucune stratégie ne s'applique !
        return Collections.emptyList();
    }
}
