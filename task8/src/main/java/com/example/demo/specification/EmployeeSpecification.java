package com.example.demo.specification;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> hasName(String name) {
        return (root, query, cb) -> (name == null || name.isBlank())
                ? null
                : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Employee> hasMinSalary(Double minSalary) {
        return (root, query, cb) -> (minSalary == null)
                ? null
                : cb.greaterThanOrEqualTo(root.get("salary"), minSalary);
    }

}
