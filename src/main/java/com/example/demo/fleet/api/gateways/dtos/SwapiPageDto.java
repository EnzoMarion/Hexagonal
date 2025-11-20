package com.example.demo.fleet.api.gateways.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SwapiPageDto {
    private List<SwapiStarshipDto> results;

}
