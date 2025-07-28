package edu.icet.demo.controller;

import edu.icet.demo.dto.Employee;
import edu.icet.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
@CrossOrigin
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public void addEmployee(@RequestBody  Employee employee){
        service.addEmployee(employee);
     }

     @GetMapping
     public List<Employee> getAll(){
        return service.getAllEmployees();
     }

     @DeleteMapping("/{id}")
     @ResponseStatus(HttpStatus.ACCEPTED)
     public String deleteEmployee(@PathVariable Integer id){
         service.deleteEmployee(id);
         return "Deleted";
     }

     @PutMapping("/{id}")
     public  void  updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
         service.updateEmployee(id,employee);
     }

     @GetMapping("/id/{id}")
     public Employee findById(@PathVariable Integer id){
         return service.findById(id);
     }

     @GetMapping("/name/{name}")
     public Employee findByFirstName(@PathVariable String name){
       return   service.findByFirstName(name);
     }

}
