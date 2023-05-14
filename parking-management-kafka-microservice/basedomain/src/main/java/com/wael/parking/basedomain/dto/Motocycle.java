package com.wael.parking.basedomain.dto;

import lombok.Data;

@Data
public class Motocycle extends Vehicule {
    public Motocycle() {
        type = VehiculeType.MOTOCYCLE;
    }

    @Override
    public boolean canPark(Spot spot) {
        return true;
    }
}