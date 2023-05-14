package com.wael.parking.motocycle_microservice.controller;

import com.wael.parking.basedomain.dto.Motocycle;
import com.wael.parking.basedomain.dto.VehiculeEvent;
import com.wael.parking.motocycle_microservice.kafka.MotocycleProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class MotocycleController {

    private MotocycleProducer motocycleProducer;

    public MotocycleController(MotocycleProducer motocycleProducer) {
        this.motocycleProducer = motocycleProducer;
    }

    @PostMapping("/motocycle-in")
    public String inMotocycleToParking(@RequestBody Motocycle motocycle) {
        motocycle.setVehiculeId(UUID.randomUUID().toString());

        VehiculeEvent motocycleEvent = new VehiculeEvent();
        motocycleEvent.setStatus("PENDING");
        motocycleEvent.setMessage("vehicule status is in pending state");
        motocycleEvent.setVehicule(motocycle);

        motocycleProducer.sendMessage(motocycleEvent);

        return "Motocycle In Successfully ...";
    }
}
