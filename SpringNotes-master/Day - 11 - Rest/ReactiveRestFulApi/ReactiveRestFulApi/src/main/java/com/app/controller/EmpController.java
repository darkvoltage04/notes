package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmpService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/emp")
public class EmpController {

	
	private EmpService service;

	@Autowired
	public EmpController(EmpService service) {
		super();
		this.service = service;
	}
	@GetMapping("/fetchAll")
	public Flux<Employee> getAllEmp()
	{
		return service.getAllEmp();
	}
	
	@PostMapping("/save")
	public Mono<Employee> createEmp(@RequestBody Employee emp)
	{
		return service.addEmp(emp);
		
	}
	
	@GetMapping("/fetch/{id}")
	public Mono<Employee> fetchById(@PathVariable      String id)
	{
		return service.getEmpById(id);
	}
	
	
	
	
	
	
	
	
	
}
