package com.example.employeemanagement.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Random;

@Data
@AllArgsConstructor
public class Employee {
    @NotNull(message ="Id should be not null ")
    @Size(min =2, message = "Id must be more than 2")
    private String id;
    @NotNull (message = "name should be not null ")
    @Size(min =4,message = "name must be more than 4")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @Email (message = "Email invalid")
    private String email;
    @Pattern(regexp = "^05\\d{8}$", message = "Invalid phone number format")
    private String phone;
    @NotNull(message = "age should be not null")
    @Positive(message = "age must be positive number")
    @Min(value = 25,message = "age must be more than 25")
    private int age;
    @NotNull(message = "position should be not null")
    @Pattern(regexp = "^(supervisor|coordinator)$")
    private String position;
    @AssertFalse (message = "onLeave must be false")
    private boolean onLeave;
    @NotNull(message = "hireDate should be not null")
    @PastOrPresent(message = "date should be in past or present")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
    @NotNull(message = "AnnualLeave hireDate should be not null")
    @Positive(message = "AnnualLeave must be positive number")
    private int AnnualLeave;




}
