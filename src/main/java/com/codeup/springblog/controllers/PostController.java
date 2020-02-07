package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
//import com.codeup.springblog.repositories.PostImageRepository;
import com.codeup.springblog.repositories.PostRepository;
//import com.codeup.springblog.repositories.TagRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
//    private final PostImageRepository postImageDao;
//    private final TagRepository tagDao;

    public PostController(PostRepository postDao,
                          UserRepository userDao
//                          PostImageRepository postImageDao,
//                          TagRepository tagDao
    ) {
        this.postDao = postDao;
        this.userDao = userDao;
//        this.postImageDao = postImageDao;
//        this.tagDao = tagDao;

    }

    //    SHOW ALL POSTS
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

//    @PostMapping("/posts/delete")
//    public String deletePost(@RequestParam long postId){
//        postDao.deleteById(postId);
//        return "posts/index";
//    }

    //    EDIT POST
    @GetMapping("/posts/{id}/edit")
    public String editPostForm(
            @PathVariable long id,
            Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

    //      DELETE POST
    @PostMapping("/posts/delete")
    public String deletePostById(@RequestParam Long postId, Model model) {
        postDao.deleteById(postId);
        return "redirect:/posts";
    }

    //    SHOW POST DETAILS
    @GetMapping("/posts/{id}")
    public String viewDetails(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userId", u.getId());
        return "posts/show";
    }


    //    CREATE POST
    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (u == null) {
            return "login";
        } else {
            model.addAttribute("post", new Post());
            return "posts/create";
        }
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(u);
        postDao.save(post);
        return "redirect:/posts";
    }

//    @GetMapping("/posts/tag/{id}")
//    public String showByTag(@PathVariable long id, Model model){
//        model.addAttribute("tag", tagDao.getOne(id));
//        return "posts/showbycat";
//    }



}
