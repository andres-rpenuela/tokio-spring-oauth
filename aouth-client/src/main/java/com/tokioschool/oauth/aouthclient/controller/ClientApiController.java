package com.tokioschool.oauth.aouthclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * http://127.0.0.1:8080/oauth2/authorization/my-client
 * Para obtener la authorización
 *
 */
@RestController
public class ClientApiController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloHandler(){
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/authorized")
    public ResponseEntity<Map<String,String>> authorizedHandler(@RequestParam String code){
        return ResponseEntity.ok(Collections.singletonMap("authorizationCode",code));
    }
}
