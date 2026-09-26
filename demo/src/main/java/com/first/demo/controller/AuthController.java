package com.first.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.first.demo.domain.User;
import com.first.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String register(
            @RequestParam String username,
            @RequestParam String password) {

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);

        return "home";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signin")
    public String login(
        @RequestParam String username,
        @RequestParam String password,
        HttpSession session) {

    User user = userRepository.findByUsername(username);

    if (user != null && user.getPassword().equals(password)) {

        session.setAttribute("loggedInUser", user);

        return "redirect:/dashboard";
    }

    return "signin";
}
}