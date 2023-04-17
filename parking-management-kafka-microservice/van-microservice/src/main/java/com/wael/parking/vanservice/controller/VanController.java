package com.wael.parking.vanservice.controller;

import com.wael.parking.basedomains.dto.Van;
import com.wael.parking.basedomains.dto.VehiculeEvent;
import com.wael.parking.vanservice.kafka.VanProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class VanController {

    private VanProducer vanProducer;

    public VanController(VanProducer vanProducer) {
        this.vanProducer = vanProducer;
    }

    @PostMapping("/van-in")
    public String inVanToParking(@RequestBody Van van) {
        van.setVehiculeId(UUID.randomUUID().toString());

        VehiculeEvent vanEvent = new VehiculeEvent();
        vanEvent.setStatus("PENDING");
        vanEvent.setMessage("vehicule status is in pending state");
        vanEvent.setVehicule(van);

        vanProducer.sendMessage(vanEvent);

        return "Van In Successfully ...";
    }
}
