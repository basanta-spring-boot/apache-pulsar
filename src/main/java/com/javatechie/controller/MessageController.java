package com.javatechie.controller;

import com.javatechie.dto.Customer;
import com.javatechie.producer.PulsarProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private PulsarProducerService producerService;

    @GetMapping("/messages/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {
        try {
            producerService.sendMessage(message);
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending message: " + e.getMessage());
        }
    }


    @PostMapping("/users")
    public ResponseEntity<String> sendCustomMessage(@RequestBody Customer customer) {
        try {
            producerService.sendCustomMessage(customer);
            return ResponseEntity.ok("Custom Message sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending message: " + e.getMessage());
        }
    }
}
