package weatherapi.test.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/CucumberTestRunner.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "json:target/cucumber-reports/CucumberTestRunner.json"},
        monochrome = true,
        glue = "weatherapi.test",
        features = "classpath:weatherapi.test.features"
)
public class CucumberTestRunner {
}
