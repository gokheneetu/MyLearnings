package org.auto.service;

import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.ContentType;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestATest {

    public void testA1() {
        RestAssured.baseURI = "";

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Berear authToken");
        request.header("Content-Type", "application/json");
        request.header("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "neetu");

        request.body(jsonObject.toString());

        Response response = request.post(baseURI);

        response.getStatusCode();
        Headers headerMap = response.getHeaders();
        headerMap.get("Content-Type");

    }

    public void test() {
        RestAssured.config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", 10000) // Response timeout (in ms)
                        .setParam("http.connection.timeout", 5000));

        RestAssured.given()
                .pathParams("userId", "2").when().get("/xyz/{userId}");

        Response response = RestAssured.given().param("name", "zuyx")
                .queryParam("age", "12")
                .when()
                .get("/users?name={name}&age={age}");

        matchesJsonSchema("demo.json");

    }
}
