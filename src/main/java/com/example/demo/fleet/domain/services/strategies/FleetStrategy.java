package com.example.demo.fleet.domain.services.strategies;

import com.example.demo.fleet.domain.models.Mission;
import com.example.demo.fleet.domain.models.entities.Starship;
import com.example.demo.fleet.infrastructure.repositories.StarshipRepository;
import java.util.List;

public interface FleetStrategy {
    boolean match(Mission mission);
    List<Starship> assign(StarshipRepository repository, Mission mission);
}
