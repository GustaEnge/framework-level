package webServiceTesting;

import io.cucumber.java.en.*;

public class Steps {

  CreateUser createUser;
  String name, job;

  @Given("^I use user creation service$")
  public void useUserCreationWebService() {
    createUser = new CreateUser();
  }

  @When("^I set name (.*)$")
  public void setName(String name) {
    createUser.setName(name);
    this.name = name;
  }

  @When("^I set job (.*)$")
  public void setJob(String job) {
  }

  @Then("^I validate my response is correct$")
  public void validateMyResponseIsCorrect() {
  }
}
