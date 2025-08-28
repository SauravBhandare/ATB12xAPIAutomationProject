package com.thetestingacademy.ex2_RestAssured_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITestingNonBDD_Style_DELETE {

    @Test
    public void test_NONBDD_STyle_DELETE(){

        String token ="eccd689dc0c8696";
        String bookingid="165" ;

        RequestSpecification r ;
        Response response;
        ValidatableResponse vr;

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token" , token);
        r.log().all();

        response = r.when().log().all().delete();

        vr = response.then().log().all().statusCode(201);



    }
}
