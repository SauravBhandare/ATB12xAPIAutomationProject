package com.thetestingacademy.ex1_Testng_AllureReport;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab1_TestCase {

    @Test
    public void test_Positive_tc1(){

        String pincode = "400092";
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
    public void test_negative_tc2(){

        String pincode = "@";
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
    public void test_negative_tc3(){

        String pincode = "";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(404)
                ;
    }
}
