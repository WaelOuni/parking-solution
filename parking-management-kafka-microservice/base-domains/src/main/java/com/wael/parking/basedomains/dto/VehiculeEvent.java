package com.wael.parking.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeEvent {
    private String message;
    private String status;
    private Vehicule vehicule;
}
