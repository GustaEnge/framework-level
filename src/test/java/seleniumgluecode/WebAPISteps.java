package seleniumgluecode;

import io.cucumber.java.en.*;
import org.junit.Assert;
import webServiceTesting.Request;
import webServiceTesting.User;

public class WebAPISteps {

  User user;
  String name, job,email;

  @Given("^I access the API$")
  public void accessAPI() throws Exception {
    Request request = new Request();
    Assert.assertEquals("Not connected","200",request.getURL_2("https://reqres.in/api/users"));
  }

  @Given("^I use user creation service$")
  public void useUserCreationWebService() {
    user = new User();
  }

  @When("^I set name (.*)$")
  public void setName(String name) {
    user.setName(name);
    this.name = name;
  }

  @When("^I set job (.*)$")
  public void setJob(String job) {
    user.setName(job);
    this.job = job;

  }

  @When("^I set email (.*)$")
  public void setEmail(String email) {
    user.setEmail(email);
    this.email = email;
  }

  @When("^I create a new register$")
  public void performHttpMethod(){
    user.postMethod(user.toStringNameJob());
  }

  @When("^I create a new register using email$")
  public void performHttpMethodEmail(){
    user.postEmail(user.toStringEmail());
  }

  @Given("^I delete an user with id = (\\d*)$")
  public void deleteUser(int id){
    user.setId(id);
    user.deleteUser();
  }

  @Then("^the user has been deleted$")
  public void statusDeleted(){
    Assert.assertEquals("Not matched message","204",Integer.toString(user.response.getStatusCode()));
    //204  | DELETE |(No Content) |
  }

  @Then("^I validate my response is correct : (.*) with status (.*)$")
  public void validateMyResponseIsCorrect(String message, String status) {
    //Assert.assertEquals("Not matched message",message,user.response.body());
    Assert.assertEquals("Not matched message",status,Integer.toString(user.response.getStatusCode()));

  }
}

