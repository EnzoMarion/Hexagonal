package com.example.demo.fleet.domain.ports;

import com.example.demo.fleet.domain.models.entities.Starship;

import java.util.List;

public interface StarshipPort {
    List<Starship> findAll();
}

