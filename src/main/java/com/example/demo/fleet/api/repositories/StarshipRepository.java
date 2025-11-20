package com.example.demo.fleet.api.repositories;

import com.example.demo.fleet.api.models.entities.Starship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StarshipRepository extends JpaRepository<Starship, Long> {

    @Override
    List<Starship> findAll();
}
