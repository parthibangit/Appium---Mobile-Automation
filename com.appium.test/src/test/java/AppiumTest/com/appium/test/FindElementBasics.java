package AppiumTest.com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class FindElementBasics {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cab = new DesiredCapabilities();
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cab);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement source = driver.findElementById("com.miui.calculator:id/btn_9_s");
		WebElement target = driver.findElementById("com.miui.calculator:id/btn_plus_s");		
		driver.findElementByAccessibilityId("element");      								 // Directly access the element with text
		source.getLocation();                                 								 // Get the location of particular element

	}

}
