package com.example.demo.fleet.api.services.strategies;

import com.example.demo.fleet.api.models.Mission;
import com.example.demo.fleet.api.models.entities.Starship;
import com.example.demo.fleet.api.repositories.StarshipRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FleetStrategyMinEntropy implements FleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return mission.getMeans() != null &&
                mission.getMeans().toUpperCase().contains("LIGHT");
    }

    @Override
    public List<Starship> assign(StarshipRepository repository, Mission mission) {
        List<Starship> all = repository.findAll();
        List<Starship> result = new ArrayList<>();

        Starship largest = all.stream()
                .filter(s -> s.getCrew() > 0)
                .max((s1, s2) -> Integer.compare(s1.getCrew(), s2.getCrew()))
                .orElse(null);

        if (largest != null) {
            result.add(largest);
        }

        return result;
    }
}
