package AppiumTest.com.appium.Dictionary;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class commonMethods {
	
	
	public static void checkElementPresentWhileScrolling(AppiumDriver<MobileElement> driver, String locator) throws InterruptedException {

		List<MobileElement> element;
		boolean value = false;
		while(value == false) {
			element =  driver.findElementsById(locator);
			if(element.size() > 0) {
				value = true;
			}			
			scrollDown(driver);
		}		
	}
	
	
	public static void scrollDown(AppiumDriver<MobileElement> driver) throws InterruptedException {
		
		Dimension dime = driver.manage().window().getSize();
		int start_w = (int) (dime.width * 0.5);
		int start_h = (int) (dime.height * 0.8);
		
		int end_w = (int) (dime.width * 0.5);
		int end_h = (int) (dime.height * 0.2);
		
					
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(start_w, start_h))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(end_w, end_h)).release().perform();
			
	}	
	
	
	public static void longPress(AppiumDriver<MobileElement> driver, MobileElement element) {
		
		TouchActions action = new TouchActions(driver);
		action.longPress(element).perform();	
	}

}
