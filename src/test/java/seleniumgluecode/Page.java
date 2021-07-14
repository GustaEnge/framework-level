package seleniumgluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import seleniumgluecode.Hook;

import java.util.concurrent.TimeUnit;

public class Page {
    private WebDriver driver;
    private String url = "https://qa-automation-challenge.github.io/sandbox/";

    public Page(){
        driver = Hook.driver;
    }

    public void launchPage(){
        driver.navigate().to(url);
    }

    public String getTitle (){
        return driver.getTitle();
    }

    public void selectType(String value){
        Select select = new Select(driver.findElement(By.id("type")));
        select.selectByVisibleText(value);
    }

    public void selectPlan(String value){
        Select select = new Select(driver.findElement(By.id("support")));
        select.selectByVisibleText(value);
    }

    public void insertMonths(String value){
        driver.findElement(By.id("duration")).sendKeys(value);
    }

    public void clickButton(){
        driver.findElement(By.id("calculate")).click();
    }

    public String getPrice(){
        return driver.findElement(By.id("price")).getText();
    }

    public void setComments(String comment) {
        driver.findElement(By.id("comments")).sendKeys(comment);
    }

    public void attachFiles(String path) throws Exception {
        WebElement attachButton = driver.findElement(By.id("attachment"));
        attachButton.click();
        TimeUnit.MILLISECONDS.sleep(500);
        attachButton.sendKeys(path);

    }
}
