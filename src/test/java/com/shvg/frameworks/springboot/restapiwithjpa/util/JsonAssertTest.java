package com.shvg.frameworks.springboot.restapiwithjpa.util;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class JsonAssertTest {

    private String expectedResponse = "{" +
            "\"id\":1, " +
            "\"name\":\"JohnDoe\"," +
            "\"age\":49," +
            "\"gender\": \"male\"" +
            "}";

    private String expectedResponse_1Line =  "{\"id\": 1, \"name\": \"JohnDoe\", \"age\": 49, \"gender\": \"male\"}";
    private String expectedResponse_Readable =  "{id: 1, name: JohnDoe, age: 49, gender: male}";

    @Test(groups = "regression")
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String actualResponse =  "{\"id\": 1, \"name\": \"JohnDoe\", \"age\": 49, \"gender\": \"male\"}";

        JSONAssert.assertEquals(expectedResponse,actualResponse,JSONCompareMode.STRICT);
        //JSONAssert.assertEquals(expectedResponse,actualResponsePartial,false);
    }

 /*   @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String actualResponsePartial =  "{\"id\": 1, \"name\": \"JohnDoe\", \"age\": 49}";

        JSONAssert.assertEquals(expectedResponse_1Line,actualResponsePartial, JSONCompareMode.LENIENT);
    }*/

    @Test
    public void jsonAssert_WithoutEscapeChars_StrictFalse() throws JSONException {
        String actualResponsePartial =  "{id: 1, name: JohnDoe, age: 49, gender: male}";
        JSONAssert.assertEquals(expectedResponse_1Line,actualResponsePartial, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals(expectedResponse_Readable,actualResponsePartial, JSONCompareMode.LENIENT);

    }

}
