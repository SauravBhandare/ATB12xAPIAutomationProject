package com.thetestingacademy.ex2_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITestingNOnBDD_Style_PATCH {

    @Test
    public void test_NonBDD_PATCH(){

        String token ="5065d815ab88f3d";
        String bookingid="2928" ;
        String payload ="{\n" +
                "    \"firstname\" : \"Saurav\",\n" +
                "    \"lastname\" : \"Bhandar\"\n" +
                "}";

        RequestSpecification r;
        Response response;
        ValidatableResponse vr;

         r = RestAssured.given();
         r.baseUri("https://restful-booker.herokuapp.com");
         r.basePath("/booking/" + bookingid);
         r.contentType(ContentType.JSON);
         r.body(payload);
         r.cookie("token", token);

         response = r.when().log().all().patch();

         vr = response.then().log().all().statusCode(200);


    }
}
