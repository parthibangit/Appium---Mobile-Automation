package AppiumTest.com.appium.Dictionary;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class dictionaryAuto {
	
	AppiumDriver<MobileElement> driver;
	WebElement element;
	
	@BeforeClass
	public void initialize() throws MalformedURLException {
		
		DesiredCapabilities cap = CapabilitiesFactory.capabilities("Appium", "Android", "7.1.2", "Android", "com.bharathdictionary", "com.bharathdictionary.BharathDictionaryActivity");
		driver =  driverFactory.driverInstance("Android", cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 0)
	public void setUp() throws InterruptedException {
		
		Thread.sleep(5000);
		boolean value = driver.findElementByAccessibilityId("Dismiss update dialogue").isDisplayed();
		if(value == true) {
			driver.findElementByAccessibilityId("Dismiss update dialogue").click();         // Click the cancel button of update window
		}
		driver.findElementById("com.bharathdictionary:id/btnok").click();                   // Agree the terms and conditions
		driver.findElementById("com.bharathdictionary:id/collapse_button").click();         // Cancel the advertisement window	
	}
	
	@Test(priority = 1)
	public void appInteractions() throws InterruptedException {
		
		element = driver.findElementById("com.bharathdictionary:id/txt_english_grammar");
		element.click();
		Thread.sleep(1000);
		driver.navigate().back();		
	}
	
	@Test(priority = 2)
	public void scrollPage() throws InterruptedException {
		
		Thread.sleep(3000);
		String locator = "com.bharathdictionary:id/txt_feedback";
		commonMethods.checkElementPresentWhileScrolling(driver, locator);
		Thread.sleep(2000);
		MobileElement element1 = driver.findElementById("com.bharathdictionary:id/txt_feedback");
		System.out.println(element1.getText());		
	}
	
	@Test(priority = 3)
	public void runningInBackground() {
		
		driver.runAppInBackground(Duration.ofSeconds(3));
		
	}
	
	@AfterTest
	public void closeApp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
}
