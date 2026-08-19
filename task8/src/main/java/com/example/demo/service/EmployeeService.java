package com.example.demo.service;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.specification.EmployeeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeResponseDTO> getAllEmployeed(){
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    public EmployeeResponseDTO getEmployeeByID(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found with id:" + id));
        return employeeMapper.toDto(employee);
    }

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto){
        Employee employee = employeeMapper.toEntity(dto);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employeeMapper.updateEntityFromDto(dto, employee);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeResponseDTO> searchEmployees(String name, Double minSalary) {
        Specification<Employee> spec = Specification.where(EmployeeSpecification.hasName(name))
                .and(EmployeeSpecification.hasMinSalary(minSalary));

        List<Employee> employees = employeeRepository.findAll(spec);
        return employees.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> getEmployeesByDeptProc(Long deptId) {
        return employeeRepository.getEmployeesByDepartmentProcedure(deptId)
                .stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

}
