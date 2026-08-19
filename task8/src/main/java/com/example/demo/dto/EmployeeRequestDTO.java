package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeeRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2 , max = 50 , message = "name must between 2 and 50")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "email should be valid")
    private String email;

    @NotNull(message = "sallary is required")
    @Positive(message = "sallary must be greater than zero")
    private Double salary;
}
