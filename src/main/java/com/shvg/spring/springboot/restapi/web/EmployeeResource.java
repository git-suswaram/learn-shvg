package com.shvg.spring.springboot.restapi.web;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shvg.spring.springboot.restapi.beans.Employee;
import com.shvg.spring.springboot.restapi.exception.EmployeeNotFoundException;
import com.shvg.spring.springboot.restapi.service.EmployeeService;
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

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/employee")
    public MappingJacksonValue get() {

        List<Employee> employees = employeeService.get();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("employeeID","firstName","lastName","jobTitle");
        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterEmployeeInfo",filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employees);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }


    @GetMapping(path = "/employee/{employeeID}")
    public MappingJacksonValue get(@PathVariable int employeeID) {

        Employee employeeByID = employeeService.get(employeeID);
        if (employeeByID == null) {
            throw new EmployeeNotFoundException("Failed to retrieve. Employee Not Found, ID = " + employeeID);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("employeeID","firstName","lastName","dateOfBirth");
        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterEmployeeInfo",filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employeeByID);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    /**
     * input - details of employee
     * output - HTTPStatus of CREATED & Return URI for the employee created
     */
    @PostMapping(path = "/employee")
    public ResponseEntity<Object> post(@Valid @RequestBody Employee employee) {

        Employee newEmployee = employeeService.post(employee);

        /*
         * Set Response status to Created
         * Send URI for newly created employee
         */

        URI newEmployeeURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newEmployee.getEmployeeID()).toUri();

        return ResponseEntity.created(newEmployeeURI).build();
    }

    @DeleteMapping(path = "/employee/{employeeID}")
    public ResponseEntity<Object> delete(@PathVariable int employeeID) {

        Employee deleteEmployeeByID = employeeService.delete(employeeID);

        if (deleteEmployeeByID == null) {
            throw new EmployeeNotFoundException("Failed to Delete. Employee Not Found, ID = " + employeeID);
        }

        return ResponseEntity.noContent().build();

    }

}
