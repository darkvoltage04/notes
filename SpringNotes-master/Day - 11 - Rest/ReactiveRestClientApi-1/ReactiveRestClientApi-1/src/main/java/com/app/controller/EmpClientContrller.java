package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmpClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/client")
public class EmpClientContrller {
	@Autowired
    private EmpClientService clientService;

    @GetMapping("/all")
    public Flux<Employee> getAllFromEmpService() {
        return clientService.fetchAllEmployees();
    }

    @GetMapping("/{id}")
    public Mono<Employee> getByIdFromEmpService(@PathVariable String id) {
        return clientService.fetchEmployeeById(id);
    }

    @PostMapping("/add")
    public Mono<Employee> createViaEmpService(@RequestBody Employee emp) {
        return clientService.saveEmployee(emp);
    }
}
