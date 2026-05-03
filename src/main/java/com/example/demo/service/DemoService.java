package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Value("${app.message:DevOps Demo Running}")
    private String message;

    public String getMessage(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return message + " - " + input;
    }
}