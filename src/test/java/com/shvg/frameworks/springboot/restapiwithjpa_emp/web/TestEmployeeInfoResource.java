package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.processor.EmployeeInfoProcessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeInfoResource.class)
public class TestEmployeeInfoResource {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeInfoProcessor employeeInfoProcessor;


    private String jsonString;

    @Before
    public void before() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EmployeesInfo employeesInfo =
                    mapper.readValue(new File("C:\\SRV_HVG\\IntelliJ_Workspace\\learn-shvg" +
                            "\\src\\test\\java\\com\\shvg\\frameworks\\springboot\\restapiwithjpa_emp" +
                            "\\web\\EmployeeInfo_Request.json"), EmployeesInfo.class);

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
        //assertEquals(jsonString, mvcResult.getResponse().getContentAsString());
    }

}
