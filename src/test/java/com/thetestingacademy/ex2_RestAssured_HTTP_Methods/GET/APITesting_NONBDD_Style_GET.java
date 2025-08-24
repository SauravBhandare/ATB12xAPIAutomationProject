package com.thetestingacademy.ex2_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_NONBDD_Style_GET {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String pincode;

    @Test
    public void test_NONBDD_Style_Positive_TC1(){

        pincode = "400092";
          r= RestAssured.given();
                r.baseUri("https://api.zippopotam.us");
                r.basePath("/IN/" + pincode);

                        response = r.log().all().get();

                                vr= response.then().log().all();
                                vr.statusCode(200);
    }

     @Test
    public void test_NONBDD_Style_NegativeTC2(){
        pincode = "@";

        r = RestAssured.given();
         r.baseUri("https://api.zippopotam.us");
         r.basePath("/IN/" + pincode);

         response = r.log().all().get();

         vr= response.then().log().all();
         vr.statusCode(404);
     }


    @Test
    public void test_NONBDD_Style_NegativeTC3(){
        pincode = "";

        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.log().all().get();

        vr= response.then().log().all();
        vr.statusCode(404);
    }


}
