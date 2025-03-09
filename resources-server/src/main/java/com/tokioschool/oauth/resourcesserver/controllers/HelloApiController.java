package com.tokioschool.oauth.resourcesserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloApiController {

    @GetMapping("")
    public ResponseEntity<String> readUserHandler(Authentication auth){
        return ResponseEntity.ok("scope: "+auth+", is Hello!.");
    }
}
