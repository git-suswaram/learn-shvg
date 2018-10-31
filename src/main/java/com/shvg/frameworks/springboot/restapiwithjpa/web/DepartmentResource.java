package com.shvg.frameworks.springboot.restapiwithjpa.web;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JDepartment;
import com.shvg.frameworks.springboot.restapiwithjpa.exception.DepartmentNotFoundException;
import com.shvg.frameworks.springboot.restapiwithjpa.service.JDepartmentService;
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
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class DepartmentResource {

    @Autowired
    private JDepartmentService jDepartmentService;

    private static final String ALL_DEPARTMENTS = "all-departments";

    @GetMapping(path = "/jpa/department", produces = "application/json")
    public Resources<JDepartment> get() {

        List<JDepartment> departments = jDepartmentService.get();

        //HATEOAS : all-users, SERVER_PATH + "/jpa/users"
        Resources<JDepartment> resources = new Resources<>(departments);
        ControllerLinkBuilder linkToAllDepts = linkTo(methodOn(this.getClass()).get());
        resources.add(linkToAllDepts.withRel(ALL_DEPARTMENTS));

        return resources;
    }


    @GetMapping(path = "/jpa/department/{departmentID}")
    public Resource<JDepartment> get(@PathVariable int departmentID) {

        Optional<JDepartment> departmentByID = jDepartmentService.get(departmentID);

        if (!departmentByID.isPresent()) {
            throw new DepartmentNotFoundException("Failed to retrieve. Department Not Found, ID = " + departmentID);
        }

        //HATEOAS : all-users, SERVER_PATH + "/jpa/users"
        Resource<JDepartment> resource = new Resource(departmentByID);
        ControllerLinkBuilder linkToAllDepts = linkTo(methodOn(this.getClass()).get());
        resource.add(linkToAllDepts.withRel(ALL_DEPARTMENTS));

        return resource;
    }

    /**
     * input - details of department
     * output - HTTPStatus of CREATED & Return URI for the department created
     */

    @PostMapping(path = "/jpa/department", produces = "application/json")
    public ResponseEntity<Object> post(@Valid @RequestBody JDepartment department) {

        JDepartment newDepartment = jDepartmentService.post(department);

        //HATEOAS : all-users, SERVER_PATH + "/jpa/users"
        Resource<JDepartment> resource = new Resource(newDepartment);
        ControllerLinkBuilder linkToAllDepts = linkTo(methodOn(this.getClass()).get());
        resource.add(linkToAllDepts.withRel(ALL_DEPARTMENTS));

        /*
         * Set Response status to Created
         * Send URI for newly created department
         */

        URI newDepartmentURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newDepartment.getId()).toUri();

        return ResponseEntity.created(newDepartmentURI).body(resource);
    }

    @DeleteMapping(path = "/jpa/department/{departmentID}")
    public ResponseEntity<Object> delete(@PathVariable int departmentID) {

        jDepartmentService.delete(departmentID);
        return ResponseEntity.noContent().build();
    }
}
