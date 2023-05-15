package com.gavinder.joblisting.controller;

import com.gavinder.joblisting.repository.PostRepository;
import com.gavinder.joblisting.model.Post;
import com.gavinder.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @GetMapping("/allPosts") //url is posts
    @CrossOrigin
    public List<Post> getAllPost(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> searchPost(@PathVariable String text){
        return srepo.findByText(text);
    }

    @PostMapping("/post") //url is post
    @CrossOrigin
    public Post addPost(@RequestBody Post post){
        repo.save(post);
        return post;
    }
}
