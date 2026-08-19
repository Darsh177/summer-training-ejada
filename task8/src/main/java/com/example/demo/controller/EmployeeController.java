package com.example.demo.controller;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployeed());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeByID(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO dto){
        return new ResponseEntity<>(employeeService.createEmployee(dto) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeRequestDTO dto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully!");
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponseDTO>> searchEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minSalary) {
        return ResponseEntity.ok(employeeService.searchEmployees(name, minSalary));
    }

    @GetMapping("/procedure/{deptId}")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByProcedure(@PathVariable Long deptId) {
        return ResponseEntity.ok(employeeService.getEmployeesByDeptProc(deptId));
    }
}
