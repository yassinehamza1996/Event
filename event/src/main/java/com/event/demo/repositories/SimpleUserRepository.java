package com.event.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.demo.models.SimpleUser;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, String>{

}
