package com.example.employeemanagement.Controller;

import com.example.employeemanagement.Model.Employee;
import com.example.employeemanagement.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api1/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
private final EmployeeService employeeService;
@GetMapping("/get")
public ResponseEntity getEmployees(){
    ArrayList<Employee> employees=employeeService.getEmployees();
    return ResponseEntity.status(HttpStatus.OK).body(employees);
}
@PostMapping("/add")
public ResponseEntity addEmployee(@Valid@RequestBody Employee employee, Errors errors){
    if (errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
    employeeService.addEmployee(employee);
    return ResponseEntity.status(HttpStatus.OK).body("Employee add");
}
@PutMapping("/update/{id}")
public ResponseEntity updateEmployee(@PathVariable String id, @Valid@RequestBody Employee employee, Errors errors){
    if (errors.hasErrors()){
       String message= errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
    boolean isUpdate=employeeService.updateEployee(id,employee);
    if(isUpdate){
        return ResponseEntity.status(HttpStatus.OK).body("Employee updated");
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found");
}
@DeleteMapping("/delete/{id}")
public ResponseEntity deleteEmployee(@PathVariable String id){
    boolean isDelete=employeeService.deleteEmployee(id);
    if (isDelete){
       return ResponseEntity.status(HttpStatus.OK).body("Employee deleted");
    }
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found");
}
@GetMapping("/getPosition/{position}")
public ResponseEntity getPosition(@PathVariable String position){
    ArrayList<Employee> e=employeeService.getPosition(position);
    return ResponseEntity.status(HttpStatus.OK).body(e);
}
@GetMapping("/getAge/{maxage}/{minage}")
public ResponseEntity getAge (@PathVariable int maxage,@PathVariable int minage){
    ArrayList<Employee> a=employeeService.getAge(maxage,minage);
    return ResponseEntity.status(HttpStatus.OK).body(a);
}
@PutMapping("/getAnnualleave/{id}")
public ResponseEntity getAnnualleave(@PathVariable String id){
    boolean isAnnualleave=employeeService.getAnnualleave(id);
    if(isAnnualleave){
        return ResponseEntity.status(HttpStatus.OK).body(" apply for annual leave done");
    }
    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
}
@GetMapping("/getNoleave")
public ResponseEntity getNoleave(){
    ArrayList<Employee> e=employeeService.getNoleave();
    return ResponseEntity.status(HttpStatus.OK).body(e);
}
@PutMapping("/promoteEmployee/{id1}/{id2}")
    public ResponseEntity promoteEmployee(@PathVariable String id1,@PathVariable String id2){
        boolean ispromoteEmployee=employeeService.promoteEmployee(id1,id2);
        if(ispromoteEmployee){
            return ResponseEntity.status(HttpStatus.OK).body(" promote Employee done ");
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
    }
}
