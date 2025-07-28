package edu.icet.demo.controller;

import edu.icet.demo.dto.Employee;
import edu.icet.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
@CrossOrigin
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

     @PostMapping
     public void addEmployee(@RequestBody  Employee employee){
        service.addEmployee(employee);
     }

     @GetMapping
     public List<Employee> getAll(){
        return service.getAllEmployees();
     }
}
