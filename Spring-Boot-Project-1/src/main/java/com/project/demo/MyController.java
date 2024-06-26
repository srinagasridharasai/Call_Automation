package com.project.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("/")
    public ResponseEntity<String> handlePostRequest(@RequestBody String requestBody) {
        // Process the POST request here
        System.out.println("Received POST request with body: " + requestBody);
        
        // Return a response
        String response = "POST request received successfully";
        return ResponseEntity.ok(response);
    }
}
