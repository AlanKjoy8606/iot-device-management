package com.example.iot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    private static final String DEVICE_EVENTS_TOPIC = "thingwire.devices.events";
    private static final String DEVICE_COMMANDS_TOPIC = "thingwire.devices.commands";
    private static final String DEVICE_RESPONSES_TOPIC = "thingwire.devices.responses";

    @Bean
    public NewTopic deviceEventsTopic() {
        return new NewTopic(DEVICE_EVENTS_TOPIC, 3, (short) 1);
    }

    @Bean
    public NewTopic deviceCommandsTopic() {
        return new NewTopic(DEVICE_COMMANDS_TOPIC, 3, (short) 1);
    }

    @Bean
    public NewTopic deviceResponsesTopic() {
        return new NewTopic(DEVICE_RESPONSES_TOPIC, 3, (short) 1);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
            ConsumerFactory<String, String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = 
            new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
