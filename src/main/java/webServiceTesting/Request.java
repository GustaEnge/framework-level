package webServiceTesting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.OutputStream;
import java.net.*;
import java.net.http.*;

import java.nio.charset.StandardCharsets;
import java.util.*;


public class Request {

    public Request(){ }

    public List<HashMap<String,String>> getURL(String URL) throws Exception {

        HttpClient client =  HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String,Object> body = mapper.readValue(response.body(), new TypeReference<HashMap<String,Object>>() {});
        List<HashMap<String,String>> data = (List) body.get("data");



        return data;
    }
    public String getURL_2(String URL) throws Exception{
        URL url = new URL(URL);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        try {
            //return (http.getResponseCode() + " " + http.getResponseMessage());
            return Integer.toString(http.getResponseCode());

        }finally {
            http.disconnect();
        }
    }

    public String postURL(String URL,String ...pairs) throws Exception {

        URL url = new URL(URL);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        String data="",resultData="";
        try {
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/json");
            for(String pair:pairs){
                String substrings[] = pair.split(":");
                String key = substrings[0];
                String value = substrings[1];
                data += String.format("\"%s\":\"%s\",", key, value);
            }
            resultData = "{"+data.substring(0,data.lastIndexOf(","))+"}";

            byte[] out = resultData.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = http.getOutputStream();
            stream.write(out);

            return (http.getResponseCode() + " " + http.getResponseMessage());

        }finally {
            http.disconnect();
        }
    }

    public String deleteUser(String URL,int id) throws Exception {
        URL url = new URL(URL+"/"+Integer.toString(id));
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        try{
            http.setRequestMethod("DELETE");
            return (http.getResponseCode() + " " + http.getResponseMessage());
        }
        finally {
            http.disconnect();
        }

    }
}
