package com.example.drawroomback.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT * FROM project.post ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Post getRandomPost();




}