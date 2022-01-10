package com.lf2a.springboot.cruddemo.service;

import com.lf2a.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);
}
