package com.first.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.first.demo.domain.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/signin";
        }

        model.addAttribute("username", user.getUsername());

        return "dashboard";
    }
}