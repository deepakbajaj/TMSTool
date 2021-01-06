package com.tms.tmsserver.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.tmsserver.domain.Task;
import com.tms.tmsserver.services.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	
	@PostMapping("")
	public ResponseEntity<?> createNewTask(@Valid @RequestBody Task task, BindingResult result){
		
		if(result.hasErrors()) {
			return new ResponseEntity<String>("Invalid Task Object", HttpStatus.BAD_REQUEST);
		}
		Task task1 = taskService.saveOrUpdateTask(task);
		return new ResponseEntity<Task>(task1, HttpStatus.CREATED);
	};
}