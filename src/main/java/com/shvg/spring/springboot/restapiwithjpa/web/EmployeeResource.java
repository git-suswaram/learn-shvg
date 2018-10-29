package com.shvg.spring.springboot.restapiwithjpa.web;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shvg.spring.springboot.restapiwithjpa.entity.JEmployee;
import com.shvg.spring.springboot.restapiwithjpa.entity.JPost;
import com.shvg.spring.springboot.restapiwithjpa.exception.EmployeeNotFoundException;
import com.shvg.spring.springboot.restapiwithjpa.service.JEmployeeService;
import com.shvg.spring.springboot.restapiwithjpa.service.JPostService;
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

    @Autowired
    private final JEmployeeService jeEmployeeService;

    @Autowired
    private final JPostService jPostService;

    private static Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

    public EmployeeResource() {
        this.jPostService=null;
        this.jeEmployeeService=null;
    }

    public EmployeeResource(JEmployeeService jeEmployeeService) {
        this.jeEmployeeService = jeEmployeeService;
        this.jPostService = null;
    }

    public EmployeeResource(JEmployeeService jeEmployeeService, JPostService jPostService) {
        this.jeEmployeeService = jeEmployeeService;
        this.jPostService = jPostService;
    }


    @GetMapping(path = "/jpa/employee")
    public MappingJacksonValue get() {
        logger.info("Entering /jpa/employee");
        List<JEmployee> employees = jeEmployeeService.get();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("employeeID", "firstName", "lastName", "jobTitle");
        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterEmployeeInfo", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employees);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping(path = "/jpa/employee/{employeeID}")
    public MappingJacksonValue get(@PathVariable int employeeID) {

        Optional<JEmployee> employeeByID = jeEmployeeService.get(employeeID);

        if (employeeByID==null || !employeeByID.isPresent()) {
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

    @GetMapping(path = "/jpa/employee/{employeeID}/posts")
    public List<JPost> get(@PathVariable Integer employeeID) {

        logger.info("Entering /jpa/employee/{id}/posts");
        Optional<JEmployee> employeeByID = jeEmployeeService.get(employeeID);

        if (employeeByID==null || !employeeByID.isPresent()) {
            throw new EmployeeNotFoundException("Failed to retrieve. Employee Not Found, ID = " + employeeID);
        }

        List<JPost> posts = employeeByID.get().getPosts();
        return posts;
    }

    @PostMapping(path = "/jpa/employee/{employeeID}/posts")
    public ResponseEntity<Object> post(@PathVariable int employeeID, @RequestBody JPost jPost) {

        logger.info("Entering /jpa/employee/{employeeId}/posts");
        Optional<JEmployee> employeeByID = jeEmployeeService.get(employeeID);

        if (employeeByID==null || !employeeByID.isPresent()) {
            throw new EmployeeNotFoundException("Failed to retrieve. Employee Not Found, ID = " + employeeID);
        }

        JEmployee jEmployee = employeeByID.get();
        jPost.setEmployee(jEmployee);

        jPostService.post(jPost);

        URI newEmployeeURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(jPost.getId()).toUri();

        return ResponseEntity.created(newEmployeeURI).build();
    }

}
