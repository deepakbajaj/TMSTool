package com.tms.tmsserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.tmsserver.domain.Task;
import com.tms.tmsserver.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public Task saveOrUpdateTask(Task task) {
		
		//Logic to be added later
		return taskRepository.save(task);
	}
}