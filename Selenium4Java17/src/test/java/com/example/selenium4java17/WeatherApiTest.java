package com.example.selenium4java17;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WeatherApiTest {

    /***
     * RestAssured().given().multiPart("file", new File("filepath")).when().post("url")
     */
    // Base URI for the OpenWeatherMap API
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "a262dde14e02c377e9806b6f237a026f"; // Replace with your API key

    @BeforeClass
    public void setup() {
        // Setting up the base URI and parameters
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void getWeatherForCity() {
        String city = "London"; // You can change this to any city you like

        // Send GET request to fetch the weather data for the city
        Response response = RestAssured.given()
                .queryParam("q", city)  // City name
                .queryParam("appid", API_KEY)  // API key
                .queryParam("units", "metric") // Optional: To get temperature in Celsius
                .get();
        RestAssured.config = RestAssured.config().httpClient(HttpClientConfig.httpClientConfig());

        // Print the response
        response.then().log().all();
//        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("demo.json"));

        // Assertions: Verify that the status code is 200
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");

        // Validate response contains necessary fields (like temperature)
        Assert.assertTrue(response.jsonPath().getString("main.temp") != null, "Temperature should be present in response");
    }

    @Test
    public void testInvalidCity() {
        String city = "InvalidCity123"; // An invalid city

        // Send GET request to fetch weather for an invalid city
        Response response = RestAssured.given()
                .queryParam("q", city)  // City name
                .queryParam("appid", API_KEY)  // API key
                .get();

        // Assert that status code is 404 for invalid city
        Assert.assertEquals(response.getStatusCode(), 404, "Expected status code 404 for invalid city");
    }

    @Test
    public void testWeatherForMultipleCities() {
        String[] cities = {"New York", "Paris", "Tokyo"};

        for (String city : cities) {
            Response response = RestAssured.given()
                    .queryParam("q", city)  // City name
                    .queryParam("appid", API_KEY)  // API key
                    .get();

            // Assert the response code is 200
            Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 for city: " + city);
        }
    }
}
