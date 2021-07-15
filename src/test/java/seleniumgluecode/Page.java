package seleniumgluecode;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Page {
    private WebDriver driver;
    private String url = "https://qa-automation-challenge.github.io/sandbox/";

    public Page(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void launchPage(){
        driver.manage().window().maximize();
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

    public void clickButton()throws InterruptedException{
        driver.findElement(By.id("calculate")).click();
        TimeUnit.MILLISECONDS.sleep(2000);
    }

    public String getPrice()  {
        return driver.findElement(By.id("price")).getText();
    }

    public void setComments(String comment) {
        WebElement commentElem = driver.findElement(By.id("comments"));
        commentElem.clear();
        commentElem.sendKeys(comment);

    }

    public void attachFiles(String path) throws Exception {
        WebElement attachButton = driver.findElement(By.id("attachment"));
        attachButton.click();
        TimeUnit.MILLISECONDS.sleep(500);
        attachButton.sendKeys(path);

    }

    public void close(){
        driver.close();
    }
}
