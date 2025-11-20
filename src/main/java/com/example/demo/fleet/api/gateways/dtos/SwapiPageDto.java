package com.example.demo.fleet.api.gateways.dtos;

import java.util.List;

public class SwapiPageDto {
    private List<SwapiStarshipDto> results;

    public List<SwapiStarshipDto> getResults() {
        return results;
    }

    public void setResults(List<SwapiStarshipDto> results) {
        this.results = results;
    }
}
