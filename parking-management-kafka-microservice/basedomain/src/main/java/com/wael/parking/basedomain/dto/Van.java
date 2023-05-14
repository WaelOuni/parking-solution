package com.wael.parking.basedomain.dto;

import lombok.Data;

@Data
public class Van extends Vehicule {
    public Van() {
        type = VehiculeType.VAN;
    }

    @Override
    public boolean canPark(Spot spot) {
        return spot.equals(Spot.LARGE_SPOT);
    }
}
