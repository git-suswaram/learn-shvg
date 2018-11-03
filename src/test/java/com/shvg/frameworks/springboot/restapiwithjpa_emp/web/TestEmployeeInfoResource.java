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
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Test(groups = "WebMvcTest")
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

    @Test
    public void getEmployeesFromEmployeeInfo() throws Exception {

        String expectedValue_employee = "[{\"employeeId\":\"1010101\",\"title\":\"Mr.\",\"firstName\":\"John\",\"middleName\":\"Lane\"," +
                "\"lastName\":\"Doe\",\"displayName\":\"Mr.John Lane Doe\"},{\"employeeId\":\"1010102\",\"title\":\"Ms.\"," +
                "\"firstName\":\"Jane\",\"middleName\":\"Lane\",\"lastName\":\"Doe\",\"displayName\":\"Ms.Jane Lane Doe\"}]";

        when(employeeInfoProcessor.get()).thenReturn(
                (Arrays.asList(
                        new EmployeeTO("1010102", "Ms.",
                                "Jane", "Lane", "Doe",
                                "Ms.Jane Doe"),
                        new EmployeeTO("1010101", "Mr.",
                                "John", "Lane", "Doe",
                                "Mr.John Doe")
                )));

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .get("/jpa/employees-info/employee")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult =
                mockMvc.perform(requestBuilder)
                        .andExpect(status().isOk())
                        .andDo(print())
                        .andExpect(content().json(expectedValue_employee))
                        .andReturn();
    }

    @Test
    public void postEmployeeInfo() throws Exception {

        String expectedValue = "[{\"employeeId\":\"1010101\",\"title\":\"Mr.\",\"firstName\":\"John\",\"middleName\":\"Lane\"," +
                "\"lastName\":\"Doe\",\"displayName\":\"Welcome Mr.John Lane Doe\"},{\"employeeId\":\"1010102\",\"title\":\"Ms.\"," +
                "\"firstName\":\"Jane\",\"middleName\":\"Lane\",\"lastName\":\"Doe\",\"displayName\":\"Welcome Ms.Jane Lane Doe\"}]";

        String postContent =
                "{\"employeeInfo\":" +
                        "[{\"employee\":" +
                        "{\"title\":\"Mr.\",\"firstName\":\"John\",\"middleName\":\"Lane\",\"lastName\":\"Doe\",\"displayName\":\"John Lane Doe\"," +
                        "\"employmentDetails\":" +
                        "{\"employeeId\":\"1010101\",\"jobTitle\":\"SVP\",\"employeeType\":\"Full-Time\",\"employmentStatus\":\"Active\"," +
                        "\"departmentID\":1234,\"departmentName\":\"Information Technology\",\"firstHireDate\":\"01/01/1985\",\"rehireDate\":\"01/01/1995\"}," +
                        "\"employmentHistory\":" +
                        "[{\"employmentStartDate\":\"01/01/1985\",\"employmentEndDate\":\"01/01/1990\",\"jobTitle\":\"Sr.Programmer\"," +
                        "\"departmentDetails\":{\"departmentID\":1234,\"departmentName\":\"Information Technology\"}}]," +
                        "\"yearlyRatings\":[{\"year\":1985,\"goal\":\"G2\",\"leadership\":\"L2\"}]," +
                        "\"compensationDetails\":" +
                        "{\"currentCompensation\":{\"baseSalary\":1101000.0,\"minAIABonusPercentage\":30,\"minAIABonusValue\":300000}," +
                        "\"compensationHistory\":[{\"year\":1985,\"startingSalary\":79892,\"salaryIncrementPercentage\":2," +
                        "\"salaryIncrementValue\":1600,\"totalYearlyIncome\":90000,\"incentives\":{\"totalIncentivesValue\":10090," +
                        "\"fixedIncentives\":[{\"incentiveType\":\"AIA\",\"percentage\":10,\"totalValue\":8000}]," +
                        "\"performanceBasedIncentives\":[{\"incentiveType\":\"NA\",\"percentage\":0,\"totalValue\":0}]}}]}}}," +
                        "{\"employee\":" +
                        "{\"title\":\"Ms.\",\"firstName\":\"Jane\",\"middleName\":\"Lane\",\"lastName\":\"Doe\",\"displayName\":\"Jane Lane Doe\"," +
                        "\"employmentDetails\":{\"employeeId\":\"1010102\",\"jobTitle\":\"VP\",\"employeeType\":\"Full-Time\",\"employmentStatus\":\"Active\"," +
                        "\"departmentID\":1234,\"departmentName\":\"Information Technology\",\"firstHireDate\":\"01/01/1985\",\"rehireDate\":\"01/01/1995\"}," +
                        "\"employmentHistory\":" +
                        "[{\"employmentStartDate\":\"01/01/1985\",\"employmentEndDate\":\"01/01/1990\",\"jobTitle\":\"Sr.Programmer\"," +
                        "\"departmentDetails\":{\"departmentID\":1234,\"departmentName\":\"Information Technology\"}}]," +
                        "\"yearlyRatings\":[{\"year\":1985,\"goal\":\"G2\",\"leadership\":\"L2\"}]," +
                        "\"compensationDetails\":" +
                        "{\"currentCompensation\":{\"baseSalary\":3.0101E7,\"minAIABonusPercentage\":30,\"minAIABonusValue\":30000}," +
                        "\"compensationHistory\":[" +
                        "{\"year\":1985,\"startingSalary\":79892,\"salaryIncrementPercentage\":2,\"salaryIncrementValue\":1600,\"totalYearlyIncome\":90000," +
                        "\"incentives\":" +
                        "{\"totalIncentivesValue\":10090,\"fixedIncentives\":[{\"incentiveType\":\"AIA\",\"percentage\":10,\"totalValue\":8000}]," +
                        "\"performanceBasedIncentives\":[{\"incentiveType\":\"NA\",\"percentage\":0,\"totalValue\":0}]}}]}}}]}\n";

        when(employeeInfoProcessor.get()).thenReturn(
                (Arrays.asList(
                        new EmployeeTO("1010102", "Ms.",
                                "Jane", "Lane", "Doe",
                                "Ms.Jane Doe"),
                        new EmployeeTO("1010101", "Mr.",
                                "John", "Lane", "Doe",
                                "Mr.John Doe")
                )));

        Map sessionAttrs = new HashMap<String, Object>();
        sessionAttrs.put("key", new StringBuilder("Test"));
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .post("/jpa/employees-info")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(postContent)
                        .contentType(MediaType.APPLICATION_JSON);
        System.out.println("requestBuilder: " + requestBuilder.toString());

        MvcResult mvcResult =
                mockMvc
                        .perform(requestBuilder)
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andReturn();
    }
}
