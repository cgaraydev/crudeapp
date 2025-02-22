package com.example.crudapp;

import com.example.crudapp.dao.IEmployeeDAO;
import com.example.crudapp.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(IEmployeeDAO iEmployeeDAO) {
        return runner -> {
//            createEmployee(iEmployeeDAO);
//            readEmployee(iEmployeeDAO);
//            employeesQuery(iEmployeeDAO);
//            employeesQueryByLastName(iEmployeeDAO, "Bustos");
//            updateEmployee(iEmployeeDAO);
//            deleteEmployee(iEmployeeDAO);
            deleteAllEmployees(iEmployeeDAO);
        };
    }

    private void deleteAllEmployees(IEmployeeDAO iEmployeeDAO) {
        System.out.println("Deleting all employees...");
        int rowsDeleted = iEmployeeDAO.deleteAll();
        System.out.println("Deleted " + rowsDeleted + " rows");
    }

    private void deleteEmployee(IEmployeeDAO iEmployeeDAO) {
        int id = 5;
        System.out.println("Deleting Employee object by id: " + id);
        iEmployeeDAO.delete(id);
    }

    private void updateEmployee(IEmployeeDAO iEmployeeDAO) {
        int id = 4;
        System.out.println("Reading Employee object by id: " + id);
        Employee employee = iEmployeeDAO.findById(id);
        System.out.println("Updating Employee object...");
        employee.setLastName("Vasquez");
        iEmployeeDAO.update(employee);
        System.out.println("Employee updated: " + employee);
    }

    private void employeesQueryByLastName(IEmployeeDAO iEmployeeDAO, String lastName) {
        List<Employee> employees = iEmployeeDAO.findByLastName(lastName);
        employees.forEach(System.out::println);
    }

    private void employeesQuery(IEmployeeDAO iEmployeeDAO) {
        List<Employee> employees = iEmployeeDAO.findAll();
        employees.forEach(System.out::println);
    }

    private void createEmployee(IEmployeeDAO iEmployeeDAO) {
        System.out.println("Creating Employee object...");
        Employee newEmployee = new Employee("John", "Doe", "8l2l0@example.com");
        System.out.println("Saving Employee object...");
        iEmployeeDAO.save(newEmployee);
        System.out.println("Employee saved: " + newEmployee);
    }

    private Employee readEmployee(IEmployeeDAO iEmployeeDAO) {
        System.out.println("Reading Employee object...");
        Employee employee = iEmployeeDAO.findById(4);
        System.out.println("Employee found: " + employee);
        return employee;
    }




}
