package com.tms.tmsserver.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.tmsserver.domain.Task;
import com.tms.tmsserver.exceptions.TaskIdException;
import com.tms.tmsserver.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public Task saveOrUpdateTask(Task task) {
		try {
			task.setTaskIdentifier(task.getTaskIdentifier().toUpperCase());
			return taskRepository.save(task);
		}catch (Exception e) {
			throw new TaskIdException("Task Identifier "+task.getTaskIdentifier().toUpperCase()+" is already exists");
		}
			
	}
	
	public Task findTaskbyIdentifier(String taskId) {
		Task task = taskRepository.findByTaskIdentifier(taskId);
		
		if(task == null) {
			
			throw new TaskIdException("Task Identifier "+taskId+" is not available");
		}
		return task;
	}
	
	public Iterable<Task> findAllProjects(){
		return taskRepository.findAll();
	}
}
