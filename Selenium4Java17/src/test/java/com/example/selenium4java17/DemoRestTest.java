package com.example.selenium4java17;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class DemoRestTest {
    //*[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/ul
    @Test
    public void dogAPITest() throws JSONException, JsonProcessingException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        Response response = RestAssured.given().get("https://api.coingecko.com/api/v3/coins/bitcoin");

//        RestAssured.given().contentType(ContentType.MULTIPART).multiPart(new File(""))
//                .contentType(ContentType.JSON).when().post("").then().extract().response();
//
//        ValidatableResponse abc = RestAssured.given().contentType(ContentType.JSON).header("Authorization", "Bearer ").when()
//                .post("").then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(""));

    response.then().assertThat().statusCode(200);

//        Object img = response.getBody().jsonPath().getJsonObject("image");
        response.getBody().jsonPath().getList();
        List<String> cl = response.getBody().jsonPath().getList("categories");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(response.getBody().jsonPath().getJsonObject("image"));
        String jsona = objectMapper.writeValueAsString(response.getBody().jsonPath().getJsonObject("categories"));
        System.out.println(jsona);

        Image image = objectMapper.readValue(json, Image.class);
        System.out.println(image);

//        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("filepath"))
    }

}
