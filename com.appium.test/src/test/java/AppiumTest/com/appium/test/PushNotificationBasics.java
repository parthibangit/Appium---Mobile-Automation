package AppiumTest.com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class PushNotificationBasics {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cab = new DesiredCapabilities();
		cab.setCapability("autoGrantPermissions", "true");                                   // Give auto permission on android devices
		cab.setCapability("autoAcceptAlerts", "true");                                       // Give auto permission on ios devices
		cab.setCapability("autoDismissAlerts", "true");                                      // Dismiss the permissions on ios devices
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cab);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);                                   
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
