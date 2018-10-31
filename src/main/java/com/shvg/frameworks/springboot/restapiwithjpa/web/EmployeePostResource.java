package com.shvg.frameworks.springboot.restapiwithjpa.web;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JEmployee;
import com.shvg.frameworks.springboot.restapiwithjpa.entity.JPost;
import com.shvg.frameworks.springboot.restapiwithjpa.exception.EmployeeNotFoundException;
import com.shvg.frameworks.springboot.restapiwithjpa.service.JEmployeeService;
import com.shvg.frameworks.springboot.restapiwithjpa.service.JPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeePostResource {

    @Autowired
    private final JEmployeeService jeEmployeeService;

    @Autowired
    private final JPostService jPostService;

    private static Logger logger = LoggerFactory.getLogger(EmployeePostResource.class);

    public EmployeePostResource() {
        this.jPostService = null;
        this.jeEmployeeService = null;
    }

    public EmployeePostResource(JEmployeeService jeEmployeeService, JPostService jPostService) {
        this.jeEmployeeService = jeEmployeeService;
        this.jPostService = jPostService;
    }

    @GetMapping(path = "/jpa/employee/{employeeID}/posts")
    public List<JPost> get(@PathVariable Integer employeeID) {

        logger.info("Entering /jpa/employee/{id}/posts");
        Optional<JEmployee> employeeByID = jeEmployeeService.get(employeeID);

        if (!employeeByID.isPresent()) {
            throw new EmployeeNotFoundException("Failed to retrieve. Employee Not Found, ID = " + employeeID);
        }

        return employeeByID.get().getPosts();
    }

    @PostMapping(path = "/jpa/employee/{employeeID}/posts")
    public ResponseEntity<Object> post(@PathVariable int employeeID, @RequestBody JPost jPost) {

        logger.info("Entering /jpa/employee/{employeeId}/posts");
        Optional<JEmployee> employeeByID = jeEmployeeService.get(employeeID);

        if (!employeeByID.isPresent()) {
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
