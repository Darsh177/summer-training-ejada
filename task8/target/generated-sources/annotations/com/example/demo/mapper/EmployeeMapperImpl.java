package com.example.demo.mapper;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-19T12:44:29+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.17 (Microsoft)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeResponseDTO toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

        employeeResponseDTO.setId( employee.getId() );
        employeeResponseDTO.setName( employee.getName() );
        employeeResponseDTO.setEmail( employee.getEmail() );
        employeeResponseDTO.setSalary( employee.getSalary() );

        return employeeResponseDTO;
    }

    @Override
    public Employee toEntity(EmployeeRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.name( dto.getName() );
        employee.email( dto.getEmail() );
        employee.salary( dto.getSalary() );

        return employee.build();
    }

    @Override
    public List<EmployeeResponseDTO> toDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeResponseDTO> list = new ArrayList<EmployeeResponseDTO>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(EmployeeRequestDTO dto, Employee employee) {
        if ( dto == null ) {
            return;
        }

        employee.setName( dto.getName() );
        employee.setEmail( dto.getEmail() );
        employee.setSalary( dto.getSalary() );
    }
}
