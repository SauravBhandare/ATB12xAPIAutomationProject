package com.thetestingacademy.ex2_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_BDD_Style_GET {

    @Test
    public void test_BDD_Style_GET_positive_tc1(){

        String  pincode = "400092";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)

                .when()
                .get()

                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void test_BDD_Style_GET_negative_tc2(){

        String  pincode = "@";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)

                .when()
                .get()

                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void test_BDD_Style_GET_negative_tc3(){

        String  pincode = "";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)

                .when()
                .get()

                .then()
                .log().all()
                .statusCode(404);
    }
}
