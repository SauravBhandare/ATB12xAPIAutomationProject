package com.thetestingacademy.ex3_Payload_Management.Hashmap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Payload_Hashmap {

    @Test
    public void test_Hashmap(){
        /*
        String payload ="{\n" +
                "    \"firstname\" : \"Test\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

         */

        // Converting response from Hashmap --> JSON
        // Converting response from Classes --> JSON
        // 1. GSON  --> Add in pom.xml any one of them
        // 2. Jackson API

        Map<String,Object> payloadrequestjson  = new LinkedHashMap<>();
        payloadrequestjson.put("firstname", "Saurav");
        payloadrequestjson.put("lastname", "Bhandare");
        payloadrequestjson.put("totalprice" , 124);
        payloadrequestjson.put("depositpaid", true);

        Map<String,Object> bookingdatesmap = new LinkedHashMap<>();
        bookingdatesmap.put("checkin", "2024-01-01");
        bookingdatesmap.put("checkout" , "2025-01-01");
        payloadrequestjson.put("bookingdates", bookingdatesmap);
        payloadrequestjson.put("additionalneeds", "Breakfast");

        System.out.println(payloadrequestjson);

        RequestSpecification r ;
        Response response;
        ValidatableResponse vr;

            r = RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/auth");
            r.contentType(ContentType.JSON);
            r.body(payloadrequestjson);
            r.log().all();

            response = r.when().log().all().post();

            vr= response.then().log().all().statusCode(200);

        }
}
