package com.thetestingacademy.ex2_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITestingBDD_STyle_PATCH {

    @Test
    public void test_BDDStyle_PATCH(){

        String token ="f05b57d41da67e3";
        String bookingid="2804" ;
        String payload ="{\n" +
                "    \"firstname\" : \"Saurav\",\n" +
                "    \"lastname\" : \"Bhandare\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + bookingid )
                .contentType(ContentType.JSON)
                .body(payload)
                .cookie("token" , token)
                .log().all()

                .when().log().all().patch()

                .then().log().all().statusCode(200);
    }
}
