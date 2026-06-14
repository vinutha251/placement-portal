package com.portal.placement.service;

import com.portal.placement.model.User;
import com.portal.placement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // REGISTER
    public String registerUser(User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            return "Email already registered!";
        }
        userRepository.save(user);
        return "Registration successful!";
    }

    // LOGIN
    public String loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return "Email not found!";
        }
        if (!user.get().getPassword().equals(password)) {
            return "Wrong password!";
        }
        return "Login successful!";
    }
}