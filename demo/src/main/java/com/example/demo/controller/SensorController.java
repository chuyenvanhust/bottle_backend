package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class SensorController {

    // Bộ nhớ tạm lưu dữ liệu nhận được
    private final List<Map<String, Object>> sensorDataList = new ArrayList<>();

    @PostMapping("/sensor")
    public ResponseEntity<String> receiveSensorData(@RequestBody Map<String, Object> payload) {
        System.out.println("Received sensor data: " + payload);
        sensorDataList.add(payload); // lưu dữ liệu
        return ResponseEntity.ok("Sensor data received successfully! " + payload);
    }

    @GetMapping("/sensor")
    public ResponseEntity<Map<String, Object>> getLatestSensorData() {
        if (sensorDataList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sensorDataList.get(sensorDataList.size() - 1));
    }

}
