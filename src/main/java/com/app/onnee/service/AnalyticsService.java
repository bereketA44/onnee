package com.app.onnee.service;


import com.app.onnee.dto.AnalyticsDTO;
import com.app.onnee.model.Profile;
import com.app.onnee.model.User;
import com.app.onnee.repository.ProfileRepository;
import com.app.onnee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileRepository profileRepository;

    public AnalyticsDTO getUserAnalytics() {
        Map<String, Object> data = new HashMap<>();
        List<User> users = userRepository.findAll();
        List<Profile> profiles = profileRepository.findAll();
        data.put("Totoal users", users.size());
        data.put("totoal profiles", profiles.size());
        data.put("Users with profile", profiles.stream().map(Profile::getUser));
        List<Long> userIdsWithProfile = profiles.stream().map(Profile::getId).toList();
        data.put("Users with no profile", users.stream().filter(user -> {
            return !userIdsWithProfile.contains(user.getId());
        }));
        AnalyticsDTO analyticsDTO = new AnalyticsDTO("Data needed for analytics", data);
        return analyticsDTO;
    }
}
