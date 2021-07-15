package webServiceTesting;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class User {

  private String name;
  private String job;
  private String email;
  private int id;
  private RequestSpecification requestSpecification;
  public Response response;


  public User() {
    this.requestSpecification = RestAssured.given()
        .baseUri("https://reqres.in/api");
  }

  public RequestSpecification getRequestSpecification() {
    return requestSpecification;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setEmail(String email) {this.email = email; }

//  public String buildBody(String ...pairs){
//    String data="",resultData="";
//    for(String pair:pairs){
//      String substrings[] = pair.split(":");
//      String key = substrings[0];
//      String value = substrings[1];
//      data += String.format("\"%s\":\"%s\",", key, value);
//    }
//    resultData = "{"+data.substring(0,data.lastIndexOf(","))+"}";
//    return resultData;
//  }

  public void postMethod(String body){
    requestSpecification.given().header("Content-Type", "application/json").body(body);
    response = requestSpecification.post("/users");

  }

  public void postEmail(String body){
    requestSpecification.given().header("Content-Type", "application/json").body(body);
    response = requestSpecification.post("/register");

  }

  public void deleteUser(){
    requestSpecification.given().contentType(ContentType.JSON).header("Content-Type", "application/json");
    response = requestSpecification.delete(Integer.toString(id));

  }

  public String toStringNameJob() {
    String name_format = String.format("\"name\": \"%s\"",name);
    String job_format = String.format("\"job\": \"%s\"",job);
    return String.format("{%s,%s}",name_format,job_format);
  }


  public String toStringEmail() {
    return String.format("{\"Email\":\"%s\"}",email);
  }
}
