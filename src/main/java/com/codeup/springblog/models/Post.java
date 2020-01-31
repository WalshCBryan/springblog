package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String body;

//    each post has it's own unique set of post details
    @OneToOne
    private PostDetails postDetails;

//    each post can have many different images associated
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImage> postImage;

//    many posts can be associated to a single user
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

//    a post can have many tags, and a tag can be associated to many posts
    @ManyToMany(mappedBy = "posts")
    private List<Tag> tags;

    public Post(){};

    public Post(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String body, User user, PostDetails postDetails) {
        this.body = body;
        this.user = user;
        this.postDetails = postDetails;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public List<PostImage> getPostImage() { return postImage; }

    public void setPostImage(List<PostImage> postImage) { this.postImage = postImage; }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
