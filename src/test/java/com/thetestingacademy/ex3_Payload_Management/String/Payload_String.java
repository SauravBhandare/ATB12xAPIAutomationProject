package com.thetestingacademy.ex3_Payload_Management.String;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Payload_String {
    // USIng NON BDD Style

    @Test
    public void test_NONBDD_Style_String() {

        String token = "febb46e15332961";
        String bookingid = "2503";
        String payload = "{\n" +
                "    \"firstname\" : \"Sauu\",\n" +
                "    \"lastname\" : \"Bhann\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r;
        Response response;
        ValidatableResponse vr;

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com") ;
        r.basePath("/booking/" + bookingid );
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payload);
        r.log().all();

        response = r.when().log().all().put();

        vr = response.then().log().all().statusCode(200);
    }
}
