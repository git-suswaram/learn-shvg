package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.repository.EmployeeRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Test(groups = "SpringRunner")
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestEmployeeRepository extends AbstractTestNGSpringContextTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getEmployeeDataFromDB(){
        List<JEEmployee> jeEmployees = employeeRepository.findAll();
        assertEquals(0,jeEmployees.size());
    }
}
