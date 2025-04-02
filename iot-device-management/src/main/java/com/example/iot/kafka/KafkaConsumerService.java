package com.example.iot.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "thingwire.devices.responses", groupId = "iot-group")
    public void consumeResponse(String message) {
        System.out.println("Received response: " + message);
    }
}
