package com.thetestingacademy;

import io.restassured.RestAssured;



public class SAmple_RA_UsingBuilder_function {
    public static void main(String[] args) {

        //TC-1
        String pincode = "400092";
        RestAssured.given()
                                .baseUri("https://api.zippopotam.us")
                                        .basePath("/IN/" + pincode)

                .when()
                        .get()

                        .then()
                        .log().all().statusCode(200);

        //TC-2
         pincode = "@";
         RestAssured.given()
                 .baseUri("https://api.zippopotam.us")
                 .basePath("/IN/" + pincode)

                 .when()
                 .get()

                 .then()
                 .log().all().statusCode(200);


        //TC-3
        pincode = " ";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)

                .when()
                .get()

                .then()
                .log().all().statusCode(200);



    }
}
