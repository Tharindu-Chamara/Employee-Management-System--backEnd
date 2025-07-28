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
}
