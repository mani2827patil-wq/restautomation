package com.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;


public class ResponseSpecificationExample {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @Test
    @BeforeClass
    public void setup() {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecification = requestSpecBuilder
                .setBaseUri("https://api.postman.com")
                .addHeader("X-Api-Key", "YOUR_API_KEY")
                .build();
        System.out.println(requestSpecification);


        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecification = responseSpecBuilder
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        System.out.println(responseSpecification);
    }

    @Test
    public void validate_status_code() {
        given().spec(requestSpecification)
                .when().get("/workspaces")
                .then().log().all().spec(responseSpecification);

    }

}

