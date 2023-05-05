package com.app.onnee.controller;

import com.app.onnee.model.User;
import com.app.onnee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/users")
    public  ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id ) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        System.out.println(user);
        try {
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        HttpStatus status = userService.deleteUser(id);
        return new ResponseEntity<>(status == HttpStatus.NOT_FOUND ? "User not found" : "User deleted",status);
    }
}
