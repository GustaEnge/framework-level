package seleniumgluecode;


import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class WebStep {

    public Page page;

    @Given("^I open Chrome and launch the application$")
    public void openChromeAndLaunchApplication()
    {
        page = new Page();
        page.launchPage();
        Assert.assertEquals("Invalid page.",page.getTitle(),"Product Subscription Configurator");
    }

    @When("^I select type (.*)$")
    public void selectType(String type)
    {
        page.selectType(type);
    }

    @When("^I select support plan (.*)$")
    public void selectSupportPlan(String plan)
    {
        page.selectPlan(plan);
    }

    @When("^I write monthly duration of (.*)$")
    public void writeMonthlyDuration (String duration)
    {
        page.insertMonths(duration);
    }

    @When("^I write comments (.*)$")
    public void leaveComments(String comment){
        page.setComments(comment);
    }

    @When("^I click in calculate price button")
    public void clickCalculatePriceButton() throws InterruptedException
    {
        page.clickButton();
        TimeUnit.MILLISECONDS.sleep(2000);

    }

    @Then("^I validate price is (.*)$")
    public void	validatePrice(String price) throws InterruptedException {
        Assert.assertEquals(price, page.getPrice());
        page.close();

    }


    @Then("^I attach files : (.*)$")
    public void	attachFile(String file) throws Exception  {
        page.attachFiles(file);
    }

}
