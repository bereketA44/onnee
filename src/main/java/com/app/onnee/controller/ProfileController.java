package com.app.onnee.controller;

import com.app.onnee.model.Profile;
import com.app.onnee.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping(path = "/profiles")
    public ResponseEntity<?> getAllProfiles() {
        return new ResponseEntity<>(profileService.getAllProfiles(), HttpStatus.OK);
    }

    @GetMapping(path = "/profiles/{id}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(profileService.getProfileById(userId), HttpStatus.OK);
    }

    @GetMapping(path = "/profiles/users/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(profileService.getProfileByUserId(id), HttpStatus.OK);
    }

    @PostMapping(path = "/profiles")
    public ResponseEntity<?> addProfile(@RequestBody Profile profile) {
        try {
            return new ResponseEntity<>(profileService.addProfile(profile), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
