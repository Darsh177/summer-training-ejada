package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Employee> employeeRowMapper = (rs, rowNum) -> new Employee(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getDouble("salary")
    );

    public List<Employee> findAll() {
        String sql = "SELECT * FROM EMPLOYEES";
        return jdbcTemplate.query(sql, employeeRowMapper);
    }

    public Optional<Employee> findById(Long id) {
        String sql = "SELECT * FROM EMPLOYEES WHERE id = ?";
        List<Employee> employees = jdbcTemplate.query(sql, employeeRowMapper, id);
        return employees.stream().findFirst();
    }

    public Employee save(Employee employee) {
        String sql = "INSERT INTO EMPLOYEES (name, email, salary) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setDouble(3, employee.getSalary());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            employee.setId(keyHolder.getKey().longValue());
        }
        return employee;
    }

    public int update(Employee employee) {
        String sql = "UPDATE EMPLOYEES SET name = ?, email = ?, salary = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getSalary(), employee.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM EMPLOYEES WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}