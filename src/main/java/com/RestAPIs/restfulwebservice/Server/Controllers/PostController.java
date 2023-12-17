package com.RestAPIs.restfulwebservice.Server.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPIs.restfulwebservice.HandleError.UserNotFoundException;
import com.RestAPIs.restfulwebservice.Server.Response;
import com.RestAPIs.restfulwebservice.Server.Entity.Post;
import com.RestAPIs.restfulwebservice.Server.Entity.User;
import com.RestAPIs.restfulwebservice.Server.Repository.PostRepository;
import com.RestAPIs.restfulwebservice.Server.Repository.UserDataRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/noLimit")
public class PostController {
    private PostRepository thePostService;
    private UserDataRepository theUserService;

    public PostController(PostRepository thePostService, UserDataRepository theUserServic) {
        super();
        this.thePostService = thePostService;
        this.theUserService = theUserServic;
    }

    @GetMapping("/posts") // Find All
    public Response getAllPosts() {
        List<Post> posts = thePostService.findAll();
        return new Response("Success", "All Posts Found", posts); // return the list of users
    }

    @GetMapping("/users/{idx}/posts")
    public Response getAllPosts(@PathVariable int idx) {
        Optional<User> theUser = theUserService.findById(idx);
        if (theUser.isEmpty() || idx < 0)
            throw new UserNotFoundException("User not found " + idx);
        List<Post> posts = theUser.get().getPosts();
        return new Response("Success", "Posts for User Found", posts);
    }

    @PostMapping("/users/{idx}/posts")
    public Response createPostForUser(@PathVariable int idx, @Valid @RequestBody Post thePost) {
        Optional<User> theUser = theUserService.findById(idx);
        if (theUser.isEmpty() || idx < 0)
            throw new UserNotFoundException("User not found " + idx);
        thePost.setuser(theUser.get());
        thePostService.save(thePost);
        return new Response("Success", "Post For User Created", thePost);
    }

}
