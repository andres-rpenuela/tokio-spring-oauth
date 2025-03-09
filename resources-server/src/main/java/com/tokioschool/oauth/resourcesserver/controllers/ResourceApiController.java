package com.tokioschool.oauth.resourcesserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResourceApiController {

    @GetMapping("/user")
    public ResponseEntity<String> readUserHandler(Authentication auht){
        return ResponseEntity.ok("scope: "+auht.getAuthorities()+", is reading.");
    }

    @PostMapping("/user")
    public ResponseEntity<String> writeUserHandler(Authentication auht){
        return ResponseEntity.ok("scope: "+auht.getAuthorities()+", is writing.");
    }
}
