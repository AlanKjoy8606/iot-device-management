package com.example.iot.service;

import com.example.iot.model.Device;
import com.example.iot.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public Device registerDevice(Device device) {
        device.setLastSeen(new Timestamp(System.currentTimeMillis()));
        return deviceRepository.save(device);
    }

    public Optional<Device> getDeviceById(String id) {
        return deviceRepository.findById(id);
    }

    public Device updateDevice(String id, Device updatedDevice) {
        return deviceRepository.findById(id).map(device -> {
            device.setName(updatedDevice.getName());
            device.setStatus(updatedDevice.getStatus());
            device.setMetadata(updatedDevice.getMetadata());
            return deviceRepository.save(device);
        }).orElseThrow(() -> new RuntimeException("Device not found"));
    }

    public void deleteDevice(String id) {
        deviceRepository.deleteById(id);
    }
}
