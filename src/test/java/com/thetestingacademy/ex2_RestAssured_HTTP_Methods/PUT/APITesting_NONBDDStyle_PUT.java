package com.thetestingacademy.ex2_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_NONBDDStyle_PUT {

    @Test
    public void test_NONBDD_Style_PUT(){

        String token ="7f8e2067adc9c78";
        String bookingid="2098";
        String payload="{\n" +
                "    \"firstname\" : \"Saurav\",\n" +
                "    \"lastname\" : \"Bhandare\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2025-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r;
        Response response;
        ValidatableResponse vr;


        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com") ;
        r.basePath("/booking/" + bookingid );
        r.contentType(ContentType.JSON);
        r.cookie("token" , token);
        r.body(payload);
        r.log().all();

        response = r.when().log().all().put();

        vr = response.then().log().all().statusCode(200);

    }
}
