package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {
        "stepDefinitions"}, tags = "@search-product", monochrome = true, dryRun = false, plugin = {"pretty", "html:target/cucumber.html",
        "json:target/cucumber.json"})
public class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
