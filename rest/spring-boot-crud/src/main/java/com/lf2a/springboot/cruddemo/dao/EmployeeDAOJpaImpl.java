package com.lf2a.springboot.cruddemo.dao;

import com.lf2a.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements IEmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");

        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        // se o id for igual a 0 ele irá salvar, caso contrario ele ira atualizar
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
