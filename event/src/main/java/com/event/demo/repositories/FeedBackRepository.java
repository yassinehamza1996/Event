package com.event.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.demo.models.FeedBack;

public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {

}
