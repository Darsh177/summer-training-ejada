package com.example.demo.mapper;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeResponseDTO toDto(Employee employee);

    Employee toEntity(EmployeeRequestDTO dto);

    List<EmployeeResponseDTO> toDtoList(List<Employee> employees);

    void updateEntityFromDto(EmployeeRequestDTO dto, @MappingTarget Employee employee);
}
