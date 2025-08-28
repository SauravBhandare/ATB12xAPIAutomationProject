package com.thetestingacademy.ex2_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting_BDDStyle_PUT {

    @Test
    public void test_BDDStyle_PUT(){

        // Generate token from Postman Create Token API
        String token = "09bb0b9ca73a9a9";
        //Generate bookingid from Cretae Booking API
        String bookingid="1703";
        String payload = "{\n" +
                "    \"firstname\" : \"Saurav\",\n" +
                "    \"lastname\" : \"Bhandare\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + bookingid )
                .contentType(ContentType.JSON)
                .cookie("token" , token)
                .body(payload).log().all()


                .when().log().all().put()

                .then().log().all().statusCode(200);



    }
}
