package com.example.demo.fleet.infrastructure.controllers;

import com.example.demo.fleet.domain.models.Mission;
import com.example.demo.fleet.domain.models.entities.Starship;
import com.example.demo.fleet.domain.services.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fleet")
public class ApiEndpointFleetController {

    @Autowired
    private FleetService fleetService;

    @PostMapping
    public List<Starship> post(@RequestBody Mission mission) {
        return fleetService.forMission(mission);
    }
}
