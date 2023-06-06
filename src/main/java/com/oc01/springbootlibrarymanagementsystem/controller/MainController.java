package com.oc01.springbootlibrarymanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    private String mainPage() {

        return "main-page";
    }
}
