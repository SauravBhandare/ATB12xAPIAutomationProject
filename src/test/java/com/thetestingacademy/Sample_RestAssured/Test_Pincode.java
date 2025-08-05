package com.thetestingacademy.Sample_RestAssured;

import io.restassured.RestAssured;

public class Test_Pincode {
    public static void main(String[] args) {

        // Added Rest Assured Dependency in pom.xml file
        //https://api.postalpincode.in/pincode/400092


        RestAssured.given()
                .baseUri("https://api.postalpincode.in/pincode/400092")


                .when()
                .get()

                .then()
                .log().all().statusCode(200);




    }
}
