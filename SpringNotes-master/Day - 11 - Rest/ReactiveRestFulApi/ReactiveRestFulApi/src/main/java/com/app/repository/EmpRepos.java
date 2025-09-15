package com.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;


@Repository
public interface EmpRepos extends ReactiveMongoRepository<Employee, String>{

}
