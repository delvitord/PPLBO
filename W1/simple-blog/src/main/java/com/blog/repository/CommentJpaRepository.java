package com.blog.repository;

import com.blog.vo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

public interface CommentJpaRepository extends JpaRepository<Comment, Serializable> {
    Comment findOneById(Long id);

    List<Comment> findAllByPostId(Long postId);

    List<Comment> findAllByPostIdOrderByRegDateDesc(Long postId);

    List<Comment> findByPostIdAndCommentContainingOrderByRegDateDesc(Long postId, String query);

}
