package com.shvg.spring.springboot.zResearch.helper;

import com.shvg.spring.springboot.zResearch.beans.Employee;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeHelper {

    private EmployeeRepository repository;
    private List<Employee> employeeList;

    public EmployeeHelper(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeHelper(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<String> getLastNames() {
        return repository.findAll().stream()
                .map(Employee::getLastName)
                .collect(Collectors.toList());
    }

    public Integer getHighestId() {
        return repository.findAll().stream()
                .mapToInt(Employee::getEmployeeID)
                .max().orElse(0);
    }

    public List<Integer> savePeople(Employee... employees) {
        return Arrays.stream(employees)
                .map(repository::save)
                .map(Employee::getEmployeeID)
                .collect(Collectors.toList());
    }

    public Employee createPerson(int id, String first, String last, LocalDate dob) {
        Employee employee = new Employee(id, first, last, dob);
        repository.save(employee);
        return employee;
    }

    public long getTotalPeople() {
        return repository.count();
    }

    public void delete(Employee employee) {
        //Implement
    }

    public void deleteAll() {
        repository.findAll().forEach(repository::delete);
    }

    public List<Employee> findByIds(Integer... ids) {
        return Arrays.stream(ids)
                .map(repository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Employee findByTaxId(Integer id) {

        for (Employee employee : employeeList) {
            if (employee.getEmployeeID() == id) {
                return employee;
            }
        }

        return null;
    }
}
