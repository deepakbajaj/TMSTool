package com.tms.tmsserver.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.tmsserver.domain.Task;
import com.tms.tmsserver.domain.User;
import com.tms.tmsserver.exceptions.TaskIdException;
import com.tms.tmsserver.repositories.TaskRepository;
import com.tms.tmsserver.repositories.UserRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Task saveOrUpdateTask(Task task, String username) {
		try {
			User user = userRepository.findByUsername(username);
			task.setUser(user);
			task.setUpdatedBy(username);
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
	
	public Iterable<Task> findAllTaskByUser(String username){
		return taskRepository.findAllByUpdatedBy(username);
	}
	
	public Iterable<Task> findAllTasks(){
		return taskRepository.findAll();
	}
}
