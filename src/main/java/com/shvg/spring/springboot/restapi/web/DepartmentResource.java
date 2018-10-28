package com.shvg.spring.springboot.restapi.web;

import com.shvg.spring.springboot.restapi.beans.Department;
import com.shvg.spring.springboot.restapi.exception.DepartmentNotFoundException;
import com.shvg.spring.springboot.restapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class DepartmentResource {

    private final DepartmentService departmentService;
    private static final String ALL_DEPARTMENTS = "all-departments";

    @Autowired
    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/department", produces = "application/json")
    public Resources<Department> get() {

        List<Department> departments = departmentService.get();

        //HATEOAS : all-users, SERVER_PATH + "/users"
        Resources<Department> resources = new Resources<>(departments);
        ControllerLinkBuilder linkToAllDepts = linkTo(methodOn(this.getClass()).get());
        resources.add(linkToAllDepts.withRel(ALL_DEPARTMENTS));

        return resources;
    }


    @GetMapping(path = "/department/{departmentID}")
    public Resource<Department> get(@PathVariable int departmentID) {

        Department departmentByID = departmentService.get(departmentID);
        if (departmentByID == null) {
            throw new DepartmentNotFoundException("Failed to retrieve. Department Not Found, ID = " + departmentID);
        }

        //HATEOAS : all-users, SERVER_PATH + "/users"
        Resource<Department> resource = new Resource(departmentByID);
        ControllerLinkBuilder linkToAllDepts = linkTo(methodOn(this.getClass()).get());
        resource.add(linkToAllDepts.withRel(ALL_DEPARTMENTS));

        return resource;
    }

    /**
     * input - details of department
     * output - HTTPStatus of CREATED & Return URI for the department created
     */

    @PostMapping(path = "/department", produces = "application/json")
    public ResponseEntity<Object> post(@Valid @RequestBody Department department) {

        Department newDepartment = departmentService.post(department);

        //HATEOAS : all-users, SERVER_PATH + "/users"
        Resource<Department> resource = new Resource(newDepartment);
        ControllerLinkBuilder linkToAllDepts = linkTo(methodOn(this.getClass()).get());
        resource.add(linkToAllDepts.withRel(ALL_DEPARTMENTS));

        /*
         * Set Response status to Created
         * Send URI for newly created department
         */

        URI newDepartmentURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newDepartment.getDepartmentID()).toUri();

        return ResponseEntity.created(newDepartmentURI).body(resource);
    }

    @DeleteMapping(path = "/department/{departmentID}")
    public ResponseEntity<Object> delete(@PathVariable int departmentID) {

        Department deleteDepartmentByID = departmentService.delete(departmentID);

        if (deleteDepartmentByID == null) {
            throw new DepartmentNotFoundException("Failed to Delete. Department Not Found, ID = " + departmentID);
        }

        return ResponseEntity.noContent().build();

    }

}
