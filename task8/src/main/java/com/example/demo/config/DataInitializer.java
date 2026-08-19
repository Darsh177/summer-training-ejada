package com.example.demo.config;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {
        // 1. إنشاء الـ Stored Procedure تلقائيًا
        jdbcTemplate.execute("DROP PROCEDURE IF EXISTS get_employee_count_by_dept");
        jdbcTemplate.execute("""
            CREATE PROCEDURE get_employee_count_by_dept(IN dept_id BIGINT, OUT dept_count INT)
            BEGIN
                SELECT COUNT(*) INTO dept_count FROM employees WHERE department_id = dept_id;
            END
        """);

        // 2. إدخال البيانات التجريبية إذا كانت الجداول فارغة
        if (departmentRepository.count() == 0) {
            Department dev = departmentRepository.save(Department.builder().name("Software Engineering").build());
            Department hr = departmentRepository.save(Department.builder().name("Human Resources").build());

            employeeRepository.save(Employee.builder()
                    .name("Moustafa")
                    .email("moustafa@example.com")
                    .salary(15000.0)
                    .department(dev)
                    .build());

            employeeRepository.save(Employee.builder()
                    .name("Ahmed")
                    .email("ahmed@example.com")
                    .salary(8000.0)
                    .department(dev)
                    .build());

            employeeRepository.save(Employee.builder()
                    .name("Sara")
                    .email("sara@example.com")
                    .salary(12000.0)
                    .department(hr)
                    .build());
        }
    }
}