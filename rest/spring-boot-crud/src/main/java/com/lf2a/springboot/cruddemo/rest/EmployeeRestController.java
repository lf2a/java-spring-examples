package com.lf2a.springboot.cruddemo.rest;

import com.lf2a.springboot.cruddemo.entity.Employee;
import com.lf2a.springboot.cruddemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeRestController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return iEmployeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = iEmployeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        iEmployeeService.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        iEmployeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = iEmployeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        iEmployeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
