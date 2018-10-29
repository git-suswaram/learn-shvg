package com.shvg.spring.springboot.restapiwithjpa.web;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shvg.spring.springboot.restapiwithjpa.entity.JEmployee;
import com.shvg.spring.springboot.restapiwithjpa.exception.EmployeeNotFoundException;
import com.shvg.spring.springboot.restapiwithjpa.service.JEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {

    private final JEmployeeService JEmployeeService;

    @Autowired
    public EmployeeResource(JEmployeeService JEmployeeService) {
        this.JEmployeeService = JEmployeeService;
    }

    @GetMapping(path = "/employee")
    public MappingJacksonValue get() {

        List<JEmployee> employees = JEmployeeService.get();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("employeeID", "firstName", "lastName", "jobTitle");
        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterEmployeeInfo", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employees);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping(path = "/employee/{employeeID}")
    public MappingJacksonValue get(@PathVariable int employeeID) {

        JEmployee employeeByID = JEmployeeService.get(employeeID);
        if (employeeByID == null) {
            throw new EmployeeNotFoundException("Failed to retrieve. Employee Not Found, ID = " + employeeID);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("employeeID", "firstName", "lastName", "dateOfBirth");
        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterEmployeeInfo", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employeeByID);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    /**
     * input - details of employee
     * output - HTTPStatus of CREATED & Return URI for the employee created
     */
    @PostMapping(path = "/employee")
    public ResponseEntity<Object> post(@Valid @RequestBody JEmployee employee) {

        JEmployee newEmployee = JEmployeeService.post(employee);

        /*
         * Set Response status to Created
         * Send URI for newly created employee
         */

        URI newEmployeeURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newEmployee.getId()).toUri();

        return ResponseEntity.created(newEmployeeURI).build();
    }

    @DeleteMapping(path = "/employee/{employeeID}")
    public ResponseEntity<Object> delete(@PathVariable int employeeID) {

        JEmployee deleteEmployeeByID = JEmployeeService.delete(employeeID);

        if (deleteEmployeeByID == null) {
            throw new EmployeeNotFoundException("Failed to Delete. Employee Not Found, ID = " + employeeID);
        }

        return ResponseEntity.noContent().build();

    }

}