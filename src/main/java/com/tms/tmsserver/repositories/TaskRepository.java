package com.tms.tmsserver.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tms.tmsserver.domain.Task;
import java.lang.String;
import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

	Task findByTaskIdentifier(String taskidentifier);
	
	@Override
	Iterable<Task> findAllById(Iterable<Long> ids); 
	
	@Override
	Iterable<Task> findAll(); 
	
}