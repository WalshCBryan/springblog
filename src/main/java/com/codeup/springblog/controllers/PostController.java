package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostImageRepository;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
//    Post post1 = new Post("Title1", "Body1");
//    Post post2 = new Post("Title2", "Body2");
//    Post post3 = new Post("Title3", "Body3");
//    Post post4 = new Post("Title4", "Body4");
//
//    @GetMapping("/posts")
//    public String postsIndex(Model model){
//        ArrayList<Post> posts = new ArrayList<>();
//        posts.add(post1);
//        posts.add(post2);
//        posts.add(post3);
//        posts.add(post4);
//        model.addAttribute("posts", posts);
//      return "posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    public String viewPost(@PathVariable int id, Model model){
//        ArrayList<Post> posts = new ArrayList<>();
//        posts.add(post1);
//        posts.add(post2);
//        posts.add(post3);
//        posts.add(post4);
//        Post postToShow = posts.get(id - 1);
//        model.addAttribute("post", postToShow);
//        return "posts/show";
//    }
//
//    @GetMapping("posts/create")
//    @ResponseBody
//    public String createNewPost(){
//        return "view form for creating posts";
//    }
//
//    @PostMapping("posts/create")
//    @ResponseBody
//    public String publishPost(){
//        return "Publishing new post";
//    }

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final PostImageRepository postImageDao;

    public PostController(PostRepository postDao, UserRepository userDao, PostImageRepository postImageDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postImageDao = postImageDao;
    }

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

    @GetMapping("/posts/edit")
    public String editPostForm(
            @RequestParam String postTitle,
            @RequestParam String postBody,
            @RequestParam Long postId, Model model) {
        model.addAttribute("postTitle", postTitle);
        model.addAttribute("postBody", postBody);
        model.addAttribute("postId", postId);
        return "posts/edit";

    }

    @PostMapping("/posts/edit")
    public String editPost(
            @RequestParam String newTitle,
            @RequestParam String newBody,
            @RequestParam long sameId) {
        Post updatePost = new Post(sameId, newTitle, newBody);
        postDao.save(updatePost);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePostById(@RequestParam Long postId, Model model) {
        postDao.deleteById(postId);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/details")
    public String viewDetails(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam String newTitle,
            @RequestParam String newbody,
            Model model) {
        Post p = new Post();
        postDao.save(p);
        return "redirect:/posts";
    }



}
