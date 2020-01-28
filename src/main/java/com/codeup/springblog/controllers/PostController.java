package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    Post post1 = new Post("Title1", "Body1");
    Post post2 = new Post("Title2", "Body2");
    Post post3 = new Post("Title3", "Body3");
    Post post4 = new Post("Title4", "Body4");

    @GetMapping("/posts")
    public String postsIndex(Model model){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        model.addAttribute("posts", posts);
      return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable int id, Model model){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        Post postToShow = posts.get(id - 1);
        model.addAttribute("post", postToShow);
        return "posts/show";
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
