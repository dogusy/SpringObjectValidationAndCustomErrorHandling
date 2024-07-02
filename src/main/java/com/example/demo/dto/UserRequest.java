package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequest {

    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be greater than 18")
    private int age;
    @NotNull(message = "Active cannot be null")
    private Boolean active;
}
