package com.tms.tmsserver.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.tmsserver.domain.Task;
import com.tms.tmsserver.services.TaskService;
import com.tms.tmsserver.services.ValidationErrorService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ValidationErrorService validationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewTask(@Valid @RequestBody Task task, BindingResult result){
		
		ResponseEntity<?> errorMap = validationErrorService.mapValidationService(result);
		if(errorMap !=null) return errorMap;
		
		Task task1 = taskService.saveOrUpdateTask(task);
		return new ResponseEntity<Task>(task1, HttpStatus.CREATED);
	};
	
	@GetMapping("/{taskIdentifier}")
	public ResponseEntity<?> getProjectById(@PathVariable String taskIdentifier){
		Task task = taskService.findTaskbyIdentifier(taskIdentifier);
		
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
}
