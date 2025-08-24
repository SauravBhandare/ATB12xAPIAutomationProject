package com.thetestingacademy.ex2_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITestingBDD_Style_POST {

    // (POST) Create token API from POSTMAN
@Test
    public void test_BDD_Style_POST_TOKEN(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .log().all()
                .body(payload)

                .when().log().all().post()

                .then().log().all().statusCode(200);


    }
}
