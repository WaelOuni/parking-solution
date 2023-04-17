package com.wael.parking.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Vehicule {
    private String vehiculeId;
    protected VehiculeType type;

    abstract boolean canPark(Spot spot);
}