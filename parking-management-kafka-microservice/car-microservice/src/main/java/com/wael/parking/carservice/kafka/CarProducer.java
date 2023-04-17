package com.wael.parking.carservice.kafka;

import com.wael.parking.basedomains.dto.VehiculeEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CarProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarProducer.class);

    private NewTopic topic;

    private KafkaTemplate<String, VehiculeEvent> kafkaTemplate;

    public CarProducer(NewTopic topic, KafkaTemplate<String, VehiculeEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(VehiculeEvent vehiculeEvent){
        LOGGER.info(String.format("Vehicule event => %s", vehiculeEvent.toString()));

        // Create Message
        Message<VehiculeEvent> message = MessageBuilder
                .withPayload(vehiculeEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }
}
