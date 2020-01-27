package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Deimos {


    @GetMapping("/deimos/{days}")
    public String countdown(@PathVariable String days, Model model) {
        model.addAttribute("days", days);
        return "countdown";
    }

//    @GetMapping("/deimos/{days}")
//    @ResponseBody
//    public String howManyDays(@PathVariable int days) {
//        return days + " days till dev day!";
//    }
}
