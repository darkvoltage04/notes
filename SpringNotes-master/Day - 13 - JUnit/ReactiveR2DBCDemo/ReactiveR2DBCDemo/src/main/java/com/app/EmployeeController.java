package com.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

	@Autowired
    private  EmployeeRepository repository;

    @PostMapping
    public Mono<Employee> create(@RequestBody Employee emp) {
       
        return repository.save(emp);
    }

    @GetMapping
    public Flux<Employee> getAll() {
        return repository.findAll();
    }
}
