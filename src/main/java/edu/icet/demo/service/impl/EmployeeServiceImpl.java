package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.Employee;
import edu.icet.demo.entity.EmployeeEntity;
import edu.icet.demo.repository.EmployeeRepository;
import edu.icet.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ObjectMapper mapper;

    @Override 
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapper.convertValue(employee, EmployeeEntity.class);
        repository.save(employeeEntity);
    }

    @Override
    public List<Employee> getAllEmployees() {
        Iterable<EmployeeEntity> all = repository.findAll();
        List<Employee> list = new ArrayList<>();
        for(EmployeeEntity entity :all){
            list.add( mapper.convertValue(entity, Employee.class));
        }
        return list;
     }

    @Override
    public void deleteEmployee(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }

    }

    @Override
    public void updateEmployee(Integer id, Employee employee) {

        if (id == null || employee == null) {
            throw new IllegalArgumentException("id and employee cannot be null");
        }

        EmployeeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

        try {
            mapper.updateValue(entity, employee);
            repository.save(entity);
        } catch (Exception e) {
            throw  new RuntimeException("Employee update failed", e);
        }
    }

    @Override
    public Employee findById(Integer id) {
        Optional<EmployeeEntity> byId = repository.findById(id);
        if(byId.isPresent()){
          return mapper.convertValue(byId.get(),Employee.class);
       }
       return  new Employee();

    }

    @Override
    public Employee findByFirstName(String name) {
        return  mapper.convertValue(repository.findByFirstName(name),Employee.class);
    }
}
