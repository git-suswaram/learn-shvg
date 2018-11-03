package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shvg.frameworks.springboot.basedata.data.DummyEmployeeJSONDataGenerator;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.entity.JEEmployee;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.processor.EmployeeInfoProcessor;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.service.impl.EmployeeServiceImpl;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.transferobjects.EmployeeTO;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

@Test(groups = "MockitoJUnitRunner")
/*@TestPropertySource(locations = {"classpath:spring-rest-api-with-jpa-emp-test-local.yml"})
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
@SpringBootTest*/
@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeProcessor extends AbstractTestNGSpringContextTests {

    @InjectMocks
    EmployeeInfoProcessor employeeInfoProcessor;

    @Mock
    private EmployeeServiceImpl employeeService;

    private String jsonString;
    private Logger logger = LoggerFactory.getLogger(EmployeeInfoResourceIT.class);

    @Before
    public void before() {
        ObjectMapper mapper = new ObjectMapper();
        EmployeesInfo employeesInfo = DummyEmployeeJSONDataGenerator.generateDummyEmployeeJSON();
        try {
            jsonString = mapper.writeValueAsString(employeesInfo);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getEmployeesFromEmployeeInfo() throws Exception {

        JEEmployee jeEmployee1 = new JEEmployee();
        jeEmployee1.setTitle("Mr.");
        jeEmployee1.setFirstName("John");
        jeEmployee1.setMiddleName("Lane");
        jeEmployee1.setLastName("Doe");
        jeEmployee1.setDisplayName("Mr.John Doe");

        JEEmployee jeEmployee2 = new JEEmployee();
        jeEmployee2.setTitle("Mr.");
        jeEmployee2.setFirstName("Jane");
        jeEmployee2.setMiddleName("Lane");
        jeEmployee2.setLastName("Doe");
        jeEmployee2.setDisplayName("Ms.Jane Doe");

        when(employeeService.get()).thenReturn(Arrays.asList(jeEmployee1, jeEmployee2));
        List<EmployeeTO> employeeTOS = employeeInfoProcessor.get();

        logger.info("employeeTOS:\n {}", employeeTOS.toString());
        assertEquals("Welcome Ms.Jane Doe", employeeTOS.get(1).getDisplayName());
        assertEquals("Welcome Mr.John Doe", employeeTOS.get(0).getDisplayName());

    }
}
