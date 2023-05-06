package com.app.onnee.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/app-version")
    public ResponseEntity<?> getVersion() {
        return new ResponseEntity<>("1.0.0 added prod env for postgres", HttpStatus.OK);
    }
}
