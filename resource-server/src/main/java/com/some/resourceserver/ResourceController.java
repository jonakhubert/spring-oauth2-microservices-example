package com.some.resourceserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/resource")
public class ResourceController {

    @GetMapping(path = "/home")
    public String home() {
        return "Home";
    }
}
