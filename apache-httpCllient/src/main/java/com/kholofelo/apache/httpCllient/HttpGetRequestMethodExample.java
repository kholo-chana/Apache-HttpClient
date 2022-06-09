package com.kholofelo.apache.httpCllient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpGetRequestMethodExample {

    public static void main(String[] args) throws IOException {

        try(CloseableHttpClient httpClient = HttpClients.createDefault()){

            //HTTP GET method
            HttpGet httpGet = new HttpGet("http://httpbin.org/get");
            System.out.println("Executing request "+ httpGet.getRequestLine());

            //Create a custom response handler
            ResponseHandler < String > responseHandler = response -> {

                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300){
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                }
                else {
                    throw new ClientProtocolException("Unexpected response status: " +status);
                }
            };
            String responseBody = httpClient.execute(httpGet, responseHandler);
            System.out.println("------------------------------------------");
            System.out.println(responseBody);

            //Calling Post Method for testing HttpClient HTTP POST Request Method Example
            post();

            //Calling Put Method for testing HttpClient HTTP PUT Request Method Example
            put();;

            //Calling Delete Method for testing HttpClient HTTP DELETE Request Method Example
            delete();
        }
    }

    //HttpClient HTTP POST Request Method Example
    public static void post() throws IOException {

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://httpbin.org/post");
            httpPost.setEntity(new StringEntity("Hello, World"));

            System.out.println("Executing request " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler < String > responseHandler = response -> {

                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };

            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }


    //HttpClient HTTP PUT Request Method Example
    public static void put() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut("http://httpbin.org/put");
            httpPut.setEntity(new StringEntity("Hello, World"));

            System.out.println("Executing request " + httpPut.getRequestLine());

            // Create a custom response handler
            ResponseHandler < String > responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };

            String responseBody = httpclient.execute(httpPut, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }

    //HttpClient HTTP DELETE Request Method Example
    public static void delete() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpDelete httpDelete = new HttpDelete("http://httpbin.org/delete");

            System.out.println("Executing request " + httpDelete.getRequestLine());

            // Create a custom response handler
            ResponseHandler < String > responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };

            String responseBody = httpclient.execute(httpDelete, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}
