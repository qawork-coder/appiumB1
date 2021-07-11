package testCases;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AlreadyInstalledApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DesiredCapabilities cap=new DesiredCapabilities(); //creating an object of the class
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.windowshop.home.HomeLauncherActivity");
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");
		
		AndroidDriver<AndroidElement> and=new AndroidDriver<AndroidElement>(cap);
		
	}

}
