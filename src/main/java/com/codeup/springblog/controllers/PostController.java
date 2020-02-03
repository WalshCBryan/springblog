package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
//import com.codeup.springblog.repositories.PostImageRepository;
import com.codeup.springblog.repositories.PostRepository;
//import com.codeup.springblog.repositories.TagRepository;
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
    @GetMapping("/posts/edit")
    public String editPostForm(
            @RequestParam long id,
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
    @GetMapping("/posts/{id}/details")
    public String viewDetails(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }


    //    CREATE POST
    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User u = userDao.getOne(1L);
        post.setUser(u);
        postDao.save(post);
        return "redirect:/posts/" + post.getId() + "/details";
    }

//    @GetMapping("/posts/tag/{id}")
//    public String showByTag(@PathVariable long id, Model model){
//        model.addAttribute("tag", tagDao.getOne(id));
//        return "posts/showbycat";
//    }


}
