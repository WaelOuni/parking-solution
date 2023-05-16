package com.wael.parking.basedomain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Vehicule {
    private String vehiculeId;
    protected VehiculeType type;

    abstract boolean canPark(Spot spot);
}