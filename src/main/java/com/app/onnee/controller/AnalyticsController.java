package com.app.onnee.controller;

import com.app.onnee.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsController {

    @Autowired
    AnalyticsService analyticsService;

    @GetMapping(path = "/analytics")
    public ResponseEntity<?> getAnalytics() {
        return new ResponseEntity<>(analyticsService.getUserAnalytics(), HttpStatus.OK);
    }
}
