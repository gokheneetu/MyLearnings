package org.auto.RestClient;

import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSender;

public class AssuredClient {

    public RestAssuredConfig configSetup(){
        RestAssuredConfig config = RestAssuredConfig.newConfig().redirect(RedirectConfig.redirectConfig().followRedirects(false));
        return config;
    }

}
