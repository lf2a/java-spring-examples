package com.lf2a.springboot.thymeleafdemo.controller;

import com.lf2a.springboot.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employeeList;

    @PostConstruct
    private void loadData() {
        Employee employee = new Employee(1, "Luiz", "Filipy", "luiz.filipy@email.com");
        Employee employee1 = new Employee(2, "Ana", "Luiza", "ana.luiza@email.com");
        Employee employee2 = new Employee(3, "Leticia", "Silva", "leticia.silva@email.com");

        employeeList = new ArrayList<>();

        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeList);

        return "list-employees";
    }
}
