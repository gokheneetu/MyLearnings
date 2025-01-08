package org.auto.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.auto.RestClient.AssuredClient;
import org.auto.RestClient.RestHttpClient;
import org.auto.config.pathUri.ConfigProperties;
import org.auto.domain.PageData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DemoTestGet extends RestHttpClient {
    RestHttpClient restHttpClient;
    ConfigProperties configProperties;
    CloseableHttpResponse cr =null;
    AssuredClient assuredClient=null;

    public DemoTestGet() {
        restHttpClient = new RestHttpClient();
        configProperties = new ConfigProperties();
        assuredClient = new AssuredClient();

    }

    public CloseableHttpResponse checkPageCount() {
         cr = restHttpClient.get(configProperties.getProp("pagecount"));
        if(cr.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            return cr;
        }else return null;
    }

    public Integer checkPageResponse(){
        if(cr ==null){
            cr = checkPageCount();
        }else {
            try {
                String res =  EntityUtils.toString(cr.getEntity(), StandardCharsets.UTF_8);
                JSONObject json = new JSONObject(res);
                Integer pageNum = (Integer) json.get("page");
                checkResponseData(json);
                return pageNum;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public List<PageData> checkResponseData(JSONObject res){
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray();
        List<PageData> pageDataList = new ArrayList<>();
        try {
             if(res.get("data") instanceof JSONArray){
                 jsonArray = new JSONArray(res.getJSONArray("data"));
             };
            pageDataList = objectMapper.readValue(jsonArray.toString(),new TypeReference<ArrayList<PageData>>() {});
            pageDataList.stream().filter(p->p.getFirstName().contains("Michael")).collect(Collectors.toList());
            System.out.println(pageDataList.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pageDataList;
    }


}
