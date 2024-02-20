package com.blog.controller;

import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blog.vo.Post;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/post")
    public Post getPost(@RequestParam("id") Long id) {
        Post post = postService.getPost(id);
        return post;
    }

    @GetMapping("/post/{id}")
    public Post getPostPathParam(@PathVariable("id") Long id) {
        Post post = postService.getPost(id);
        return post;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        List<Post> posts = postService.getPosts();
        return posts;
    }

    @RequestMapping("/posts/updtdate/asc")
    public List<Post> getPostsOrderByUpdtDateAsc() {
        List<Post> posts = postService.getPostsOrderByUpdtDateAsc();
        return posts;
    }

    @RequestMapping("/posts/regdate/desc")
    public List<Post> getPostsOrderByRegDateDesc() {
        List<Post> posts = postService.getPostsOrderByRegDateDesc();
        return posts;
    }

    @RequestMapping("/posts/search/title")
    public List<Post> searchByTitle(@RequestParam("query") String query) {
        List<Post> posts = postService.searchPostsByTitle(query);
        return posts;
    }

    @RequestMapping("/posts/search/content")
    public List<Post> searchByContent(@RequestParam("query") String query) {
        List<Post> posts = postService.searchPostsByContent(query);
        return posts;
    }


}
