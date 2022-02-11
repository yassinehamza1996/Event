package com.event.demo.repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import com.event.demo.models.History;
@NoRepositoryBean
public interface HistoryRepository  extends JpaRepository<History, Integer>{
	@Query("select h from History where h.historyDate = :historyDate")
Collection<History> findHistoryByDate(@Param("historyDate") Date historyDate);
}
