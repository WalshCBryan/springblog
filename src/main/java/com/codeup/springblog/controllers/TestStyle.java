package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestStyle {

    @GetMapping("/test-style")
    public String returnTest() {
        return "test-style";
    }

}
