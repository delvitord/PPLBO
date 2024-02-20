package com.blog.service;


import com.blog.repository.PostRepository;
import com.blog.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private static List<Post> posts;
    @Autowired
    PostRepository postRepository;
    public Post getPost(Long id) {
        Post post = postRepository.findOne(id);

        return post;
    }

    public List<Post> getPosts() {
        List<Post> postList = postRepository.findPosts();
        return postList;
    }

    public List<Post> getPostsOrderByUpdtDateAsc() {
        List<Post> postList = postRepository.findPostOrderByUpdtDateAsc();
        return postList;
    }

    public List<Post> getPostsOrderByRegDateDesc() {
        List<Post> postList = postRepository.findPostOrderByRegDateDesc();
        return postList;
    }

    public List<Post> searchPostsByTitle(String query) {
        List<Post> posts = postRepository.findPostLikeTitle(query);
        return posts;
    }

    public List<Post> searchPostsByContent(String query) {
        List<Post> posts = postRepository.findPostLikeContent(query);
        return posts;
    }
}
