package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee , Long> {
}
