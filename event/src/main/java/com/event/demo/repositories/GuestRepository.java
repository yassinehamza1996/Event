package com.event.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.demo.models.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
