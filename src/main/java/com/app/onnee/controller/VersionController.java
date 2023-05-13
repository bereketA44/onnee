package com.app.onnee.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VersionController {

    @GetMapping("/app-version/{version}")
    public ResponseEntity<?> getVersion(@PathVariable String version) {
        Map<String, String> map = new HashMap<>();
        map.put("v1", "1.0.0 add postgres");
        map.put("v2", "2.0.0 added prod env for postgres");
        map.put("v3", "2.0.1 added cloned env");
        map.put("v4", "3.0.0 CI/CD added");
        return new ResponseEntity<>(map.get(version), HttpStatus.OK);
    }

}
