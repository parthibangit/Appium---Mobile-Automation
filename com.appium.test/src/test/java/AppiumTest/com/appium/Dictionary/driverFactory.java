package AppiumTest.com.appium.Dictionary;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class driverFactory {
	
	static AppiumDriver<MobileElement> driver;
	
	
	public static AppiumDriver<MobileElement> driverInstance(String driverName, DesiredCapabilities capabilities) throws MalformedURLException {
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		if(driverName.equalsIgnoreCase("Android")) {
			
			driver = new AndroidDriver<>(url, capabilities);
			return driver;
			
		}
		
		else {
			
			driver = new IOSDriver<>(url, capabilities);
			return driver;
			
		}		
	}
	
}
