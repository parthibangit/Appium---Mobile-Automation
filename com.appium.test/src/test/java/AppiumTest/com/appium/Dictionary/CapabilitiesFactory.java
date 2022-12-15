package AppiumTest.com.appium.Dictionary;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilitiesFactory {
	
	
	public static DesiredCapabilities capabilities(String automationName, String platformName, String platformVersion, String deviceName, String appPackage, String appActivity) {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		
		if(appPackage != null && appActivity != null) {
			
			cap.setCapability("appPackage", appPackage);
			cap.setCapability("appActivity", appActivity);
		}
		cap.setCapability("autoGrantPermissions", true);
		
		return cap;
		
	}
	

}
