package AppiumTest.com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppTest {
    
  
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities cab = new DesiredCapabilities();
		cab.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cab.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cab.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cab.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
//		cab.setCapability(MobileCapabilityType.APP, "V:\\Automation - Appium\\Appium File\\Sample Android App Test_v1.0_apkpure.com.apk");
		cab.setCapability("appPackage", "com.miui.calculator");
		cab.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cab);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		driver.findElementById("com.miui.calculator:id/btn_9_s").click();
		driver.findElementById("com.miui.calculator:id/btn_plus_s").click();
		driver.findElementById("com.miui.calculator:id/btn_5_s").click();
		driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
		Thread.sleep(2000);
		String value = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView[3]/android.widget.LinearLayout/android.widget.TextView[2]").getText();
		
		if(value.equals("14")) {
			System.out.println("Test passed...");
		}
		
		else {
			System.out.println("Test failed");
		}
		
		driver.quit();
		
		
	}
	
	
}
