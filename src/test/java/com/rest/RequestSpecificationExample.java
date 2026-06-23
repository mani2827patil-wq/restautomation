package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RequestSpecificationExample {


    @BeforeClass
    public void beforeClass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecification = requestSpecBuilder
                .setBaseUri("https://api.postman.com")
                .addHeader("X-Api-Key", "YOUR_API_KEY")
                .build();

        System.out.println(requestSpecification);


    }

    @Test
    public void validate_status_code() {
        given().spec(requestSpecification).

                when().get("/workspaces").
                then().log().all().contentType(ContentType.JSON)
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
}
