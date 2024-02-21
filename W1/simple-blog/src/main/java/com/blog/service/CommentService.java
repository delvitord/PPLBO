package com.blog.service;

import com.blog.repository.CommentJpaRepository;
import com.blog.vo.Comment;
import com.blog.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentJpaRepository commentJpaRepository;

    public boolean saveComment(Comment comment) {
        Comment result = commentJpaRepository.save(comment);
        boolean isSuccess = true;

        if(result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public Comment getComment(Long id) {
        Comment comment = commentJpaRepository.findOneById(id);
        return comment;
    }

    public List<Comment> getComments(Long postId) {
        List<Comment> comments = commentJpaRepository.findAllByPostIdOrderByRegDateDesc(postId);
        return comments;
    }

    public List<Comment> searchCommentByPost(Long postId, String query) {
        List<Comment> comments = commentJpaRepository.findByPostIdAndCommentContainingOrderByRegDateDesc(postId, query);
        return comments;
    }

    public boolean deleteComment(Long postId) {
        Comment result = commentJpaRepository.findOneById(postId);

        if(result == null) {
            return false;
        }

        commentJpaRepository.deleteById(postId);
        return true;
    }




}
