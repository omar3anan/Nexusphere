package com.RestAPIs.restfulwebservice.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestAPIs.restfulwebservice.Server.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
