package com.nikhil.xmeme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nikhil.xmeme.entities.User;
import com.nikhil.xmeme.repositories.IUserRepository;

@Controller
public class RegistrationController {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(final IUserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signup")
    public String showRegistrationForm(final Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
