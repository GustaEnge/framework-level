package webServiceTesting.unit;

import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webServiceTesting.User;

public class UserTest {

  User user = new User();
  String jsonWithUserAndJob = "{\n" +
      "    \"name\": \"testName\",\n" +
      "    \"job\": \"testJob\"\n" +
      "}";

  String jsonWithUserNameSurnameAndJob = "{\n" +
      "    \"name\": \"testName autoSurname\",\n" +
      "    \"job\": \"testJob\"\n" +
      "}";


  @Before
  public void setup() {
    user.setName("testName");
    user.setJob("testJob");
  }

  @Test
  public void buildBody_validUserAndJob_shouldReturnJsonWithUserAndJob() {
    user.postMethod(jsonWithUserAndJob);
    String body = user.response.getBody().asString();
    //Assert.assertEquals(jsonWithUserAndJob, user.response.getBody().asString().contains());
    Assert.assertEquals("Response body doesn't contain testName",body.contains("testName") ,true );
    Assert.assertEquals("Response body doesn't contain testJob",body.contains("testJob") ,true );
  }

  @Test
  public void buildBodyWithSurname_validUserAndJob_shouldReturnJsonWithUserNameSurnameAndJob() {

    user.postMethod(jsonWithUserNameSurnameAndJob);
    String body = user.response.getBody().asString();
    //Assert.assertEquals(jsonWithUserAndJob, user.response.getBody().asString().contains());
    Assert.assertEquals("Response body doesn't contain testName",body.contains("testName autoSurname") ,true );
    Assert.assertEquals("Response body doesn't contain testJob",body.contains("testJob") ,true );

  }

}