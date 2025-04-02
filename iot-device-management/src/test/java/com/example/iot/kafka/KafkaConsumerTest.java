package com.example.iot.kafka;

import com.example.iot.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class KafkaConsumerTest {

    @Mock
    private DeviceService deviceService;

    @InjectMocks
    private KafkaConsumer kafkaConsumer;

    @Test
    void testConsumeDeviceResponse() {
        String message = "{ \"id\": \"1234\", \"status\": \"ONLINE\" }";
        kafkaConsumer.consumeDeviceResponse(message);

        verify(deviceService, times(1)).updateDeviceStatus(any(), any());
    }
}
