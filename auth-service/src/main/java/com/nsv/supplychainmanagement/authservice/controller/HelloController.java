package com.nsv.supplychainmanagement.authservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/api")
public class HelloController {


    @GetMapping("/hello")
    public String hello(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This endpoint is public!";
    }

    @GetMapping("/protected")
    public String protectedEndpoint(Principal principal) {
        return "🔐 Hello, " + principal.getName();
    }
}
