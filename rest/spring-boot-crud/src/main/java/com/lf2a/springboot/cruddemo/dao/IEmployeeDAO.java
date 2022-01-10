package com.lf2a.springboot.cruddemo.dao;

import com.lf2a.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);
}
