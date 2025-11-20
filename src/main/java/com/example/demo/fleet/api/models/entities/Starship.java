package com.example.demo.fleet.api.models.entities;

import com.example.demo.fleet.api.models.enums.StarshipType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Starship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private String model;

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
