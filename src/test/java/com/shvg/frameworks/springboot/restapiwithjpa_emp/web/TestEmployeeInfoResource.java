package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.processor.EmployeeInfoProcessor;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Test
//@RunWith(SpringRunner.class)
//@WebAppConfiguration
@WebMvcTest(EmployeeInfoResource.class)
public class TestEmployeeInfoResource extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @BeforeMethod
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @MockBean
    private EmployeeInfoProcessor employeeInfoProcessor;

    private String jsonString;


    @Before
    public void before() {

        ObjectMapper mapper = new ObjectMapper();
        try {
            EmployeesInfo employeesInfo =
                    mapper.readValue(new File("C:\\SRV_HVG\\IntelliJ_Workspace\\learn-shvg" +
                            "\\src\\test\\resources\\sampleRequest\\EmployeeInfo_Request.json"), EmployeesInfo.class);

            jsonString = mapper.writeValueAsString(employeesInfo);
            System.out.println(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void post() throws Exception {

        //Call /jpa/employees-info
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jpa/employees-info")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(jsonString))
                .andReturn();
    }
}
