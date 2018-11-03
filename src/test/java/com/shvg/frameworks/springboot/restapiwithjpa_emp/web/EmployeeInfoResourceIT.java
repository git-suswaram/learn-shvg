package com.shvg.frameworks.springboot.restapiwithjpa_emp.web;

import org.json.JSONException;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "SpringRunner")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class EmployeeInfoResourceIT extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private Logger logger = LoggerFactory.getLogger(EmployeeInfoResourceIT.class);

    @Test
    public void contextLoads() throws JSONException {

        String expectedValue=
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

        String response = this
                .testRestTemplate
                .getForObject("/jpa/hardcoded-employees-info-json", String.class);

        logger.info("\nResponse for /jpa/hardcoded-employees-info-json : \n{}", response);

        JSONAssert.assertEquals(expectedValue,response,false);
    }
}
