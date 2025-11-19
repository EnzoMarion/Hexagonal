package com.example.demo.fleet.api.models.entities;

import com.example.demo.fleet.api.models.enums.Breed;
import lombok.Data;
import lombok.Builder;
import jakarta.persistence.*;

@Data
@Builder
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private final Breed breed;

    @Column
    private int recruits;
}
