//package com.codeup.springblog.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class LoginController {
//
//    @GetMapping("/login")
//    public String showLoginform(){
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(
//            @RequestParam String username,
//            @RequestParam String password, Model model){
//
////        ArrayList<String> shoppingCart = new ArrayList<>();
////        shoppingCart.add("apples");
////        shoppingCart.add("oranges");
////        shoppingCart.add("bananas");
//
//        boolean isAdmin = false;
//        if(username.equals("Admin") && password.equals("Password")){
//            isAdmin = true;
//        }
//
////        model.addAttribute("username", username);
////        model.addAttribute("password", password);
////        model.addAttribute("shoppingCart", shoppingCart);
////        model.addAttribute("isAdmin", isAdmin);
//        return "profile";
//    }
//}
