package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hi() {
        return "redirect:/posts";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String Hello() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String Hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }


}
