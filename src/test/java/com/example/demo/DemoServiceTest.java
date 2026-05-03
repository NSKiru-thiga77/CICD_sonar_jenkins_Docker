package com.example.demo;

import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoServiceTest {

    DemoService service = new DemoService();

    @Test
    void testMessage() {
        assertThrows(IllegalArgumentException.class, () -> service.getMessage(null));
    }
}