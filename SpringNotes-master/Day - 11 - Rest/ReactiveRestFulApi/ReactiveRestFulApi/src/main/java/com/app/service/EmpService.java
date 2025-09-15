package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repository.EmpRepos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepos repos;

	public Flux<Employee> getAllEmp()
	{
		return repos.findAll();
	}
	
	public Mono<Employee> getEmpById(String id)
	{
		return repos.findById(id);
	}
	
	public Mono<Employee> addEmp(Employee emp)
	{
		return repos.save(emp);
	}
	
	public Mono<Void> deleteEmpById(String id)
	{
		return repos.deleteById(id);
	}
	
	
}
