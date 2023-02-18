package stepDefinitions.base;

import static driver.DriverFactory.cleanDriver;
import static driver.DriverFactory.getDriver;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Timestamp;

public class Hooks {
	public WebDriver driver;

	@Before
	public void setup() throws IOException {
		getDriver();

	}
	@AfterStep
	public void captureExceptionImage(Scenario scenario) {
		if(scenario.isFailed()) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis(), System.currentTimeMillis());
			String timeMilliseconds = Long.toString(timestamp.getSeconds());
			
			byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", timeMilliseconds);
		}
		
	}

	@After
	public void tearDown() {
		cleanDriver();
	}

}
