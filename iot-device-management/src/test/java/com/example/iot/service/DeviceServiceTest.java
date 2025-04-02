package com.example.iot.service;

import com.example.iot.entity.Device;
import com.example.iot.repository.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class DeviceServiceTest {

    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceService deviceService;

    @Test
    void testGetDeviceById() {
        UUID id = UUID.randomUUID();
        Device device = new Device();
        device.setId(id);
        device.setName("Smart Light");

        when(deviceRepository.findById(id)).thenReturn(Optional.of(device));

        Device foundDevice = deviceService.getDeviceById(id);
        assertNotNull(foundDevice);
        assertEquals("Smart Light", foundDevice.getName());
    }
}
