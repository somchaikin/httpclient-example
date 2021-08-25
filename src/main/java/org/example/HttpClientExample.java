package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpClientExample {
    public static void main(String[] args) throws IOException {
        HttpGet request =new HttpGet("https://httpbin.org/get");

        request.addHeader(HttpHeaders.USER_AGENT,"bot");
        request.addHeader(HttpHeaders.ACCEPT_ENCODING,"UTF-8");
        request.addHeader("Custom-Key","customkey");

        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request)){

            System.out.println(response.getProtocolVersion());
            System.out.println(response.getStatusLine().getStatusCode());

            HttpEntity entity=response.getEntity();
            if(entity !=null){
                System.out.println(EntityUtils.toString(entity));
            }
        }
    }
}
