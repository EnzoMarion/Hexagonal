package com.example.demo.fleet.api.models.entities;

import com.example.demo.fleet.api.models.enums.StarshipType;
import lombok.Data;
import lombok.Builder;
import jakarta.persistence.*;

@Data
@Builder
@Entity
public class Starship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private StarshipType category;

    @Column
    private int length;
    @Column
    private int crew;
    @Column
    private int passengers;
    @Column
    private int count;
}
