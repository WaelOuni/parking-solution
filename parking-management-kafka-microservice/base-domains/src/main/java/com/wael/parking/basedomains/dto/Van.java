package com.wael.parking.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Van extends Vehicule {
    public Van() {
        type = VehiculeType.VAN;
    }

    @Override
    boolean canPark(Spot spot) {
        return spot.equals(Spot.LARGE_SPOT);
    }
}
