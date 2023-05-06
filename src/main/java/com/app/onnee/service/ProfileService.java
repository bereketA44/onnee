package com.app.onnee.service;

import com.app.onnee.model.Profile;
import com.app.onnee.model.User;
import com.app.onnee.repository.ProfileRepository;
import com.app.onnee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserRepository userRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileByUserId(Long userId) {
        return profileRepository.getProfileByUserId(userId);
    }
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile addProfile(Profile profile) throws Exception {
        User user = userRepository.findById(profile.getUser().getId()).orElse(null);
        if (user == null) {
            throw new Exception("User not found");
        }
//        user.setProfile(profile);
//        user.getProfile().setUser(user);

//        profile.getUser().setProfile(profile);
//        user.setProfile(profile);
//
        profile.setUser(user);
        Profile newProfile = profileRepository.save(profile);
        user.setProfile(newProfile);
        userRepository.save(user);
        return newProfile;
    }
}
