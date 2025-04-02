package com.example.iot.controller;

import com.example.iot.entity.Device;
import com.example.iot.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DeviceController.class)
class DeviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeviceService deviceService;

    @Test
    void testRegisterDevice() throws Exception {
        Device device = new Device();
        device.setId(UUID.randomUUID());
        device.setName("Temperature Sensor");

        Mockito.when(deviceService.registerDevice(Mockito.any())).thenReturn(device);

        mockMvc.perform(post("/devices")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Temperature Sensor\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Temperature Sensor"));
    }
}
