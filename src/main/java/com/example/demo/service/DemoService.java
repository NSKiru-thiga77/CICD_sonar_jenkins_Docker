package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    // ❌ Hardcoded secret (security issue)
    private String password = "admin123";

    // ❌ Null pointer risk
    public String getMessage(String input) {
        if (input.equals("test")) {   // ❌ will throw NPE
            return "Working";
        }
        return null; // ❌ bad practice
    }

    // ❌ High complexity (Sonar issue)
    public int complex(int a) {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (a > 5) {
                if (a > 8) {
                    result += i;
                } else {
                    result += i * 2;
                }
            } else {
                result += i * 3;
            }
        }
        return result;
    }
}