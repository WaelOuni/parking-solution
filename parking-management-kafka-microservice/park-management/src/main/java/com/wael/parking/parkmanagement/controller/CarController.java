package com.wael.parking.parkmanagement.controller;

import com.wael.parking.basedomains.dto.Car;
import com.wael.parking.basedomains.dto.Vehicule;
import com.wael.parking.basedomains.dto.VehiculeEvent;
import com.wael.parking.parkmanagement.kafka.CarProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class CarController {

    private CarProducer carProducer;

    public CarController(CarProducer carProducer) {
        this.carProducer = carProducer;
    }

    @PostMapping("/car-in")
    public String inCarToParking(@RequestBody Car car){
        car.setVehiculeId(UUID.randomUUID().toString());

        VehiculeEvent carEvent = new VehiculeEvent();
        carEvent.setStatus("PENDING");
        carEvent.setMessage("vehicule status is in pending state");
        carEvent.setVehicule(car);

        carProducer.sendMessage(carEvent);

        return "Car In Successfully ...";
    }
}
