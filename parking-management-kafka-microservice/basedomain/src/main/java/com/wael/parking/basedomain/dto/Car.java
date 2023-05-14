package com.wael.parking.basedomain.dto;

import lombok.Data;

@Data
public class Car extends Vehicule {
    public Car() {
        type = VehiculeType.CAR;
    }

    @Override
    public boolean canPark(Spot spot) {
        return spot.equals(Spot.CAR_SPOT) || spot.equals(Spot.LARGE_SPOT);
    }
}