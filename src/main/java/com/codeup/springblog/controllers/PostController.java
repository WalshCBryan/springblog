package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex(){
      return "An index of all posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable int id){
        return "Showing post id#: " + id;
    }

    @GetMapping("posts/create")
    @ResponseBody
    public String createNewPost(){
        return "view form for creating posts";
    }

    @PostMapping("posts/create")
    @ResponseBody
    public String publishPost(){
        return "Publishing new post";
    }

}
