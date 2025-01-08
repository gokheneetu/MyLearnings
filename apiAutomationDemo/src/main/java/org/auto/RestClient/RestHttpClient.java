package org.auto.RestClient;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

public class RestHttpClient {
    public static CloseableHttpClient httpClient = null;

    public RestHttpClient(){
        httpClient = HttpClients.createDefault();
    }

    public CloseableHttpResponse get(String url){
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse closeableHttpResponse;
        try {
            closeableHttpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return closeableHttpResponse;
    }
    public void post(String url, HttpRequest httpRequest){
        HttpHost httpPost = new HttpHost(url);
        try {
            httpClient.execute(httpPost,httpRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
