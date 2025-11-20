package com.example.demo.fleet.api.services.strategies;

import com.example.demo.fleet.api.models.Mission;
import com.example.demo.fleet.api.models.entities.Starship;
import com.example.demo.fleet.api.repositories.StarshipRepository;
import java.util.List;

public interface FleetStrategy {
    boolean match(Mission mission);
    List<Starship> assign(StarshipRepository repository, Mission mission);
}
