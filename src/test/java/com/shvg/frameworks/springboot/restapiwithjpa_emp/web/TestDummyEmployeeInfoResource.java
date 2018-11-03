package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shvg.frameworks.springboot.basedata.data.DummyEmployeeJSONDataGenerator;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.web.dummy.DummyBusinessService;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.web.dummy.DummyEmployeeInfoResource;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Test
/*
@RunWith(SpringRunner.class)
@WebAppConfiguration
*/
@WebMvcTest(DummyEmployeeInfoResource.class)
public class TestDummyEmployeeInfoResource extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Autowired
    private DummyBusinessService dummyBusinessService;

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

    @Test
    public void test_getJsonHardCoded() throws Exception {

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .get("/jpa/hardcoded-employees-info-json")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult =
                mockMvc.perform(requestBuilder)
                        .andExpect(status().isOk())
                        .andExpect(content().json(jsonString))
                        .andReturn();
        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), strict);
    }

    @Test
    public void getJsonFromBusinessService() throws Exception {

        when(dummyBusinessService.retrieveHardCodedJson()).thenReturn(
                DummyEmployeeJSONDataGenerator.generateDummyEmployeeJSON());

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .get("/jpa/employees-info-business")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult =
                mockMvc.perform(requestBuilder)
                        .andExpect(status().isOk())
                        .andExpect(content().json(jsonString))
                        .andReturn();
    }
}
