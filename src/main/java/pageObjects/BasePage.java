/** 
	created by ozkansaricam
	https://github.com/ozkansaricam
*/
 

package pageObjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.DriverFactory;


public class BasePage {
	public BasePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public static String getURL() {
		String url = null;
		try {
			Properties prop = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
			prop.load(file);
			url = prop.getProperty("url").toLowerCase().trim();
			}catch (Exception e) {
				System.out.println(e);
			}
		
		return url;
	}
	public static String getTag() {
		String tag = null;
		try {
			Properties prop = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
			prop.load(file);
			tag = prop.getProperty("tag").toLowerCase().trim();
			}catch (Exception e) {
				System.out.println(e);
			}
		
		return tag;
	}

	public WebDriver getDriver() {
		return DriverFactory.getDriver();
	}

	public void navigateTo_URL(String url) {
		getDriver().get(url);
	}

	public void sendKeys(By by, String textToType) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
	}
	public void pressEnter(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(Keys.ENTER);
	}

	public void sendKeys(WebElement element, String textToType) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
	}

	public void waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForWebElementAndClick(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void waitForWebElementAndClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void waitForAlert_And_ValidateText(String text) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		String alert_Message_Text = getDriver().switchTo().alert().getText();
		Assert.assertEquals(alert_Message_Text, text);
	}

}
