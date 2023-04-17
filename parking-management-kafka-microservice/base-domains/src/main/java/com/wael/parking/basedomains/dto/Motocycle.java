package com.wael.parking.basedomains.dto;

import lombok.Data;

@Data
public class Motocycle extends Vehicule {
    public Motocycle() {
        type = VehiculeType.MOTOCYCLE;
    }

    @Override
    boolean canPark(Spot spot) {
        return true;
    }
}