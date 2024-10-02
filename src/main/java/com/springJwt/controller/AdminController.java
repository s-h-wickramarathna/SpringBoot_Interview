package com.springJwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin_only")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @GetMapping("/dashboard")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello from admin only url");
    }

}
