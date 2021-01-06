package com.tms.tmsserver.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tms.tmsserver.domain.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

	@Override
	Iterable<Task> findAllById(Iterable<Long> ids); 
	
}