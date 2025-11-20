package com.example.demo.fleet.api.controllers;

import com.example.demo.fleet.api.models.Mission;
import com.example.demo.fleet.api.models.entities.Starship;
import com.example.demo.fleet.api.services.FleetService;
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
