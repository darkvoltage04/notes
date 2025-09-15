package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmpClientService {

    private final WebClient webClient;

    @Autowired
    public EmpClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    // Fetch all employees
    public Flux<Employee> fetchAllEmployees() {
        return webClient.get()
                .uri("/fetchAll")
                .retrieve()
                .bodyToFlux(Employee.class);
    }

    // Fetch employee by ID
    public Mono<Employee> fetchEmployeeById(String id) {
        return webClient.get()
                .uri("/fetch/{id}", id)
                .retrieve()
                .bodyToMono(Employee.class);
    }

    // Add new employee
    public Mono<Employee> saveEmployee(Employee employee) {
        return webClient.post()
                .uri("/save")
                .bodyValue(employee)
                .retrieve()
                .bodyToMono(Employee.class);
    }
}
