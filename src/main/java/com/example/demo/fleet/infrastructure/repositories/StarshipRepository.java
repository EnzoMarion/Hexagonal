package com.example.demo.fleet.infrastructure.repositories;

import com.example.demo.fleet.domain.ports.StarshipPort;
import com.example.demo.fleet.domain.models.entities.Starship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StarshipRepository extends JpaRepository<Starship, Long>, StarshipPort {
    @Override
    List<Starship> findAll();
}
