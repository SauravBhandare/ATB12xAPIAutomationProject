package com.thetestingacademy.ex2_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITestingNONBDD_Style_POST {

    RequestSpecification r ;
    Response response;
    ValidatableResponse vr;

   @Test
    public void test_NONBDD_Style_Token(){

       String payload = "{\n" +
               "    \"username\" : \"admin\",\n" +
               "    \"password\" : \"password123\"\n" +
               "}";

      r = RestAssured.given();
              r.baseUri("https://restful-booker.herokuapp.com");
                      r.basePath("/auth");
                      r.contentType(ContentType.JSON);
                      r.body(payload);

                      response = r.when().log().all().post();

                      vr= response.then().log().all().statusCode(200);
    }
}
