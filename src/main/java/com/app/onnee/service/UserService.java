package com.app.onnee.service;

import com.app.onnee.model.User;
import com.app.onnee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) throws Exception {
        if (userRepository.getUserByUsername(user.getUsername()).isPresent()) {
            throw new Exception("user name taken");
        }
        User newUser = new User(user.getUsername(), user.getDescription());
        return userRepository.save(newUser);
    }

    public User getUser(Long id) {
       return userRepository.findById(id).orElse(null);
    }

    public HttpStatus deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return HttpStatus.NO_CONTENT;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }
}
