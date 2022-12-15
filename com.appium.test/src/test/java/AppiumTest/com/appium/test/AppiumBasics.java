package AppiumTest.com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;

public class AppiumBasics {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cab = new DesiredCapabilities();
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cab);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.hideKeyboard();                                     // Used to hide the keyboard
		driver.getKeyboard();                                      // Open the keyboard
		driver.lockDevice();                                       // Lock the device. If already lock silently return.
		driver.isDeviceLocked();                                   // If device is locked it will return true or false otherwise
		driver.unlockDevice();                                     // Unlock the device
		driver.toggleAirplaneMode();                               // Turn on the airplane mode
		driver.toggleData();                                       // Turn on the data
		driver.toggleLocationServices();                           // Turn on the location service
		driver.toggleWifi();                                       // Turn on the wifi
		driver.sendSMS("phoneNumber", "message");       		   // Send the message from connected emulator
		driver.runAppInBackground(Duration.ofSeconds(2000));       // Run the app in background
		
		IOSDriver<MobileElement> ios = new IOSDriver<>(url, cab);
		ios.activateApp("bundle_ID");                               // Activate the app if app running background
		ios.terminateApp("bundle_ID");                              // Terminate the app if it is running.

	}

}
