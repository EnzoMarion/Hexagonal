package com.example.demo.fleet.api.gateways;

import com.example.demo.fleet.api.gateways.dtos.SwapiPageDto;
import com.example.demo.fleet.api.gateways.dtos.SwapiStarshipDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class SwapiProxy {
    private final WebClient client = WebClient.create("https://swapi.dev/api");

    public List<SwapiStarshipDto> fetch() {
        List<SwapiStarshipDto> results = new ArrayList<>();
        int page = 1;
        boolean finished = false;

        while (!finished) {
            try {
                SwapiPageDto pageDto = client
                        .get()
                        .uri("/starships/?page={page}", page)
                        .retrieve()
                        .bodyToMono(SwapiPageDto.class)
                        .block();

                if (pageDto != null && pageDto.getResults() != null && !pageDto.getResults().isEmpty()) {
                    results.addAll(pageDto.getResults());
                    page++;
                } else {
                    finished = true;
                }
            } catch (Exception e) {
                finished = true;
            }
        }
        return results;
    }
}
