package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/WebAPI.feature"
        ,glue= {"seleniumgluecode"}
        ,plugin = { "pretty", "html:target/cucumber-reports" }
        ,tags = "@Regression"
        ,monochrome = true

)
public class TestRunWebAPI {
}
