package edu.icet.demo.controller;

import edu.icet.demo.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>();

     @PostMapping
     public void addEmployee(@RequestBody  Employee employee){
        employeeList.add(employee);
        System.out.println(employee);
    }
}
