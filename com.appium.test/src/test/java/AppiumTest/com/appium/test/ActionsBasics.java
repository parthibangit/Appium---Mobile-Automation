package AppiumTest.com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class ActionsBasics {

	public static void main(String[] args) throws MalformedURLException {
		
		
		DesiredCapabilities cab = new DesiredCapabilities();
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cab);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement source = driver.findElementById("com.miui.calculator:id/btn_9_s");
		WebElement target = driver.findElementById("com.miui.calculator:id/btn_plus_s");
		
		TouchActions action = new TouchActions(driver);
		action.longPress(source).moveToElement(target).release().perform();               // drag and drop the element
		action.scroll(target, 10, 100).perform();                                         // Scroll until given element visible
		action.longPress(target).moveToElement(target, 50, 50).release().perform();       // Progress bar scrolling
		action.singleTap(target).perform();                                               // Single tab the element
		action.doubleTap(target).perform();                                               // Double tab the element
		
	}

}
