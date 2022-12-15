package AppiumTest.com.appium.alarm;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AppiumTest.com.appium.Dictionary.CapabilitiesFactory;
import AppiumTest.com.appium.Dictionary.commonMethods;
import AppiumTest.com.appium.Dictionary.driverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class alarmAuto {
	
	AppiumDriver<MobileElement> driver;
	String labelText;
	
	@BeforeClass
	public void setUpMobile() throws MalformedURLException {
		
		DesiredCapabilities cap = CapabilitiesFactory.capabilities("Appium", "Android", "7.1.2", "Android", "com.android.deskclock", "com.android.deskclock.DeskClockTabActivity");
		driver = driverFactory.driverInstance("Android", cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@BeforeTest
	public void checkIsItAlarmPage() throws InterruptedException {
		Thread.sleep(4000);
		String tabName = driver.findElementById("com.android.deskclock:id/alarm").getText();
		Assert.assertEquals(tabName, "Alarms");		
	}
	
	@Test(priority = 0)
	public void selectAlarmFromDisplay() {
		
		List<MobileElement> displayList =  driver.findElementsById("com.android.deskclock:id/digitalClock");
		int totalSize = displayList.size();
		displayList.get(totalSize-1).click();
		
	}
	
	@Test(priority = 1)
	public void modifyAlarm() throws InterruptedException {
		
		String actualText = driver.findElementById("android:id/title").getText();
		Assert.assertEquals(actualText, "Set alarm");
		
		// Set alarm label
		MobileElement labelInput = driver.findElementById("com.android.deskclock:id/alarm_label");
		labelInput.sendKeys("Test Label");
		
		Thread.sleep(2000);
		labelText =  labelInput.getText();
		
		// Set time for alarm
		List<MobileElement> datePickerList = driver.findElementsById("miui:id/numberpicker_input");
		
		for(int i=0; i<datePickerList.size(); i++) {
			
			if(i==0) {
				datePickerList.get(i).sendKeys("2");
			}
			else if (i == 1) {
				datePickerList.get(i).sendKeys("00");
			}
			
			else if (i == 2) {
				datePickerList.get(i).sendKeys("PM");				
			}			
		}
		
		driver.findElementById("android:id/button2").click();
	}
	
	@Test(priority = 2)
	public void turnOffAlarm() {
		
		// Verify the label text in alarm display
		String actualText = driver.findElementById("com.android.deskclock:id/label").getText();
		Assert.assertEquals(actualText, labelText);
		
		// Get the size of the display alaram list and turn off the latest created alarm
		List<MobileElement> totalSize = driver.findElementsById("com.android.deskclock:id/clock_onoff");
		int size = totalSize.size();
		int lastAlarmIndex = size-1;
		totalSize.get(lastAlarmIndex).click();
		MobileElement turnOffButton = driver.findElementByXPath("//android.widget.TextView[2]");
		turnOffButton.click();	
		
	}
	
	@Test(priority = 3)
	public void deleteAlarm() {
		
		// Click the latest created alarm from list
		MobileElement latestAlarm = driver.findElementByXPath("//android.widget.LinearLayout[3]");
		commonMethods.longPress(driver, latestAlarm);
		
		// Delete the latest created alarm from list
		
		
	}
	
	@AfterTest
	public void closeApp() {
		
		driver.closeApp();
	}

}
