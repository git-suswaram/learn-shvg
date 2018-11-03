package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.processor.EmployeeInfoProcessor;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.transferobjects.EmployeeTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeInfoResource {

    @Autowired
    private EmployeeInfoProcessor employeeInfoProcessor;

    private static Logger logger = LoggerFactory.getLogger(EmployeeInfoResource.class);

    @GetMapping("/jpa/employees-info/employee")
    public MappingJacksonValue get() {
        List<EmployeeTO> employeeTOS = employeeInfoProcessor.get();

        for (EmployeeTO employeeTO : employeeTOS) {
            employeeTO
                    .setDisplayName(
                            employeeTO.getTitle()
                                    .concat(employeeTO.getFirstName())
                                    .concat(" ")
                                    .concat(employeeTO.getMiddleName())
                                    .concat(" ")
                                    .concat(employeeTO.getLastName())
                    );
        }
        return new MappingJacksonValue(employeeTOS);
    }

    @PostMapping(path = "/jpa/employees-info")
    public ResponseEntity<Object> post(@Valid @RequestBody EmployeesInfo employeesInfo) {

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().build(employeesInfo);

        assert employeeInfoProcessor != null;
        employeeInfoProcessor.post(employeesInfo);
        return ResponseEntity.created(uri).build();
    }
}
