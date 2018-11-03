package com.shvg.frameworks.springboot.basedata.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shvg.frameworks.springboot.restapiwithjpa_emp.pojo.EmployeesInfo;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Test
@RunWith(PowerMockRunner.class)
@PrepareForTest(DummyEmployeeJSONDataGenerator.class)
public class TestDummyEmployeeJSONDataGenerator extends PowerMockTestCase {

    @Before
    public void setUp() {
        p("Call mockStatic DummyEmployeeJSONDataGenerator.class to enable static mocking");
        PowerMockito.mockStatic(DummyEmployeeJSONDataGenerator.class);

    }
    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }

    @Test
    public void stubStaticMethod() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        EmployeesInfo employeesInfo =
                mapper.readValue(new File("C:\\SRV_HVG\\IntelliJ_Workspace\\learn-shvg" +
                        "\\src\\main\\resources\\sampleRequest\\EmployeeInfo_Request.json"), EmployeesInfo.class);

        p("Stub static method DummyEmployeeJSONDataGenerator.generateDummyEmployeeJSON");
        PowerMockito.mockStatic(DummyEmployeeJSONDataGenerator.class);
        Mockito.when(DummyEmployeeJSONDataGenerator.generateDummyEmployeeJSON())
                .thenReturn(employeesInfo);
//        PowerMock.replay(DummyEmployeeJSONDataGenerator.class);
    }

    private void p(String s) {
        System.out.println(s);
    }
}