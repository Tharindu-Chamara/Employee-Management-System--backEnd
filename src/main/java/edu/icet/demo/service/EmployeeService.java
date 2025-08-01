package edu.icet.demo.service;

import edu.icet.demo.dto.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer id);

    void updateEmployee(Integer id,Employee employee);

    Employee findById(Integer id);

    Employee findByFirstName(String name);
}

