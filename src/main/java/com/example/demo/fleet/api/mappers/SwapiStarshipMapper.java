package com.example.demo.fleet.api.mappers;

import com.example.demo.fleet.api.gateways.dtos.SwapiStarshipDto;
import com.example.demo.fleet.api.models.entities.Starship;
import com.example.demo.fleet.api.models.enums.StarshipType;
import org.springframework.stereotype.Component;

@Component
public class SwapiStarshipMapper {

    public Starship toDomain(SwapiStarshipDto dto) {
        return Starship.builder()
                .name(dto.getName())
                .model(dto.getModel())
                .category(mapCategory(dto.getStarshipClass()))
                .length(toInt(dto.getLength()))
                .crew(toInt(dto.getCrew()))
                .passengers(toInt(dto.getPassengers()))
                .count(0)
                .build();
    }

    private StarshipType mapCategory(String sc) {
        if (sc == null) return StarshipType.OTHER;
        String s = sc.toUpperCase();
        if (s.contains("DESTROYER")) return StarshipType.DESTROYER;
        if (s.contains("FIGHTER") || s.contains("WING")) return StarshipType.FIGHTER;
        if (s.contains("CRAFT") || s.contains("CORVETTE")) return StarshipType.CRAFT;
        if (s.contains("FREIGHTER") || s.contains("CARGO")) return StarshipType.CARGO;
        if (s.contains("STATION")) return StarshipType.STATION;
        return StarshipType.OTHER;
    }

    private int toInt(String val) {
        if (val == null || val.equalsIgnoreCase("unknown") || val.equalsIgnoreCase("n/a"))
            return 0;
        try {
            return Integer.parseInt(val.replaceAll("[,\\s]", ""));
        } catch (Exception e) {
            return 0;
        }
    }
}
