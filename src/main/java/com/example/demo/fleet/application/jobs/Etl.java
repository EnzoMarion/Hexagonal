package com.example.demo.fleet.application.jobs;

import com.example.demo.fleet.infrastructure.gateways.SwapiProxy;
import com.example.demo.fleet.infrastructure.mappers.SwapiStarshipMapper;
import com.example.demo.fleet.domain.models.entities.Starship;
import com.example.demo.fleet.infrastructure.repositories.StarshipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Component
public class Etl implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Etl.class);

    @Autowired
    private StarshipRepository repository;
    @Autowired
    private SwapiStarshipMapper mapper;
    @Autowired
    private SwapiProxy swapi;

    @PostConstruct
    @Scheduled(fixedRate = 3600000)
    @Transactional
    public void run() {
        LOGGER.info("Import périodique en cours...");
        try {
            List<Starship> all = swapi.fetch()
                    .stream()
                    .map(dto -> mapper.toDomain(dto))
                    .toList();
            repository.deleteAll();
            repository.saveAll(all);
            LOGGER.info("Import périodique exécutée !");
        } catch (Exception e) {
            LOGGER.warn("Import périodique en échec : SWAPI ne répond pas", e);
        }
    }
}
