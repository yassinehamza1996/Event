package com.event.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.event.demo.models.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
	@Query("SELECT e FROM Evenement e where e.eventCode=:eventCode")
	EvenementRepository findByeventCode(@Param("eventCode") int eventCode);
	
	@Query("DELETE FROM Evenement e where e.eventCode=:eventCode")
	void deleteEventByeventCode(@Param("eventCode") int eventCode);
}
