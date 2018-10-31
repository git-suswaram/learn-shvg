package com.shvg.frameworks.springboot.restapiwithjpa.web;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shvg.frameworks.springboot.restapiwithjpa.entity.JEmployee;
import com.shvg.frameworks.springboot.restapiwithjpa.exception.EmployeeNotFoundException;
import com.shvg.frameworks.springboot.restapiwithjpa.service.JEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController

public class EmployeeResource {

    /* @Value("env.variables.domain.URL")
     private String domainUrl;
 */
    @Autowired
    private final JEmployeeService jeEmployeeService;

    private static Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

    public EmployeeResource() {
        jeEmployeeService = null;
    }

    public EmployeeResource(JEmployeeService jeEmployeeService) {
        this.jeEmployeeService = jeEmployeeService;
    }

    @GetMapping(path = {"/jpa/employees", "/jpa/employees/count"})
    public MappingJacksonValue get() throws Exception {

        logger.info("Entering /jpa/employee");
        String requestURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .toUriString()
                .replace("http://localhost:8080", "");
        logger.info("ServletUriComponentsBuilder requestURI: {}", requestURI);

        if ("/jpa/employees".equals(requestURI)) {
            List<JEmployee> employees = getEmployees();
            SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("employeeID", "firstName", "lastName", "jobTitle");
            FilterProvider filters = new SimpleFilterProvider().addFilter("FilterEmployeeInfo", filter);

            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employees);
            mappingJacksonValue.setFilters(filters);
            return mappingJacksonValue;
        } else if ("/jpa/employees/count".equals(requestURI)) {
            long employeeCount = getEmployeesCount();

            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employeeCount);
            return mappingJacksonValue;
        } else {
            throw new Exception("Unhandled URI");
        }
    }

    @GetMapping(path = "/jpa/employee/{employeeID}")
    public MappingJacksonValue get(@PathVariable int employeeID) {

        Optional<JEmployee> employeeByID = jeEmployeeService.get(employeeID);

        if (!employeeByID.isPresent()) {
            throw new EmployeeNotFoundException("Failed to retrieve. Employee Not Found, ID = " + employeeID);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("employeeID", "firstName", "lastName", "dateOfBirth");
        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterEmployeeInfo", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employeeByID);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @PostMapping(path = "/jpa/employee")
    public ResponseEntity<Object> post(@Valid @RequestBody JEmployee employee) {

        JEmployee newEmployee = jeEmployeeService.post(employee);

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

    @DeleteMapping(path = "/jpa/employee/{employeeID}")
    public ResponseEntity<Object> delete(@PathVariable int employeeID) {

        jeEmployeeService.delete(employeeID);
        return ResponseEntity.noContent().build();
    }

    private long getEmployeesCount() {
        long employeeCount = jeEmployeeService.count();
        return employeeCount;
    }

    private List<JEmployee> getEmployees() {
        List<JEmployee> employees = jeEmployeeService.get();
        return employees;
    }
}
