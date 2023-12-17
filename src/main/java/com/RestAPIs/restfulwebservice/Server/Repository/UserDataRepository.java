package com.RestAPIs.restfulwebservice.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestAPIs.restfulwebservice.Server.Entity.User;

public interface UserDataRepository extends JpaRepository<User, Integer> {

}
