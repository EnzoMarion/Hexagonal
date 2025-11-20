package com.example.demo.fleet.api.services.strategies;

import com.example.demo.fleet.api.models.Mission;
import com.example.demo.fleet.api.models.entities.Starship;
import com.example.demo.fleet.api.repositories.StarshipRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FleetStrategyMinCost implements FleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return mission.getMeans() != null &&
                mission.getMeans().toUpperCase().contains("CHEAP");
    }

    @Override
    public List<Starship> assign(StarshipRepository repository, Mission mission) {
        List<Starship> all = repository.findAll();
        List<Starship> result = new ArrayList<>();

        Starship cheapest = all.stream()
                .filter(s -> s.getLength() > 0)
                .min((s1, s2) -> Integer.compare(s1.getLength(), s2.getLength()))
                .orElse(null);

        if (cheapest != null) {
            result.add(cheapest);
        }

        return result;
    }
}
