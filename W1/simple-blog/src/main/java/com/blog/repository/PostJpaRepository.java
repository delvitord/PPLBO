package com.blog.repository;

import com.blog.vo.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("PostJpaRepository")
public interface PostJpaRepository extends JpaRepository<Post, Serializable> {
    Post findOneById(Long id);
    List<Post> findAllByOrderByUpdtDateDesc();

    List<Post> findAllByOrderByUpdtDateAsc();

}
