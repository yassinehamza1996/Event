package com.event.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.event.demo.models.SuperUser;

@Repository
public interface SuperUserRepository extends JpaRepository<SuperUser, Integer>{
@Query("SELECT s from SuperUser s where s.email=:email")
SuperUser findSuperUserByEmail(@Param("email")String email);
}
