package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shvg.frameworks.springboot.basedata.data.DummyEmployeeJSONDataGenerator;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.processor.EmployeeInfoProcessor;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.transferobjects.EmployeeTO;
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

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Test
/*
@RunWith(SpringRunner.class)
@WebAppConfiguration
*/
@WebMvcTest(EmployeeInfoResource.class)
public class TestEmployeeInfoResource extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Autowired
    private EmployeeInfoProcessor employeeInfoProcessor;

    private String jsonString;

    @BeforeMethod
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

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

   @Test(groups="regression")
    public void getEmployeesFromEmployeeInfo() throws Exception {

        when(employeeInfoProcessor.get()).thenReturn(
                (Arrays.asList(
                        new EmployeeTO("1010102","Ms.",
                                "Jane","Lane","Doe",
                                "Ms.Jane Doe"),
                        new EmployeeTO("1010101","Mr.",
                                "John","Lane","Doe",
                                "Mr.John Doe")
                        )));

        String expectedValue="[{\"employeeId\":\"1010101\",\"title\":\"Mr.\",\"firstName\":\"John\",\"middleName\":\"Lane\"," +
                "\"lastName\":\"Doe\",\"displayName\":\"Welcome Mr.John Lane Doe\"},{\"employeeId\":\"1010102\",\"title\":\"Ms.\"," +
                "\"firstName\":\"Jane\",\"middleName\":\"Lane\",\"lastName\":\"Doe\",\"displayName\":\"Welcome Ms.Jane Lane Doe\"}]";

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .get("/jpa/employees-info/employee")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult =
                mockMvc.perform(requestBuilder)
                        .andExpect(status().isOk())
                        .andExpect(content().json(expectedValue))
                        .andReturn();
        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), strict);
    }
}
