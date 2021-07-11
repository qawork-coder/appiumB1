package base;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseSetup {

	public static AndroidDriver<AndroidElement> getAndroidDriver() {

		File fs = new File("src/main/java/utilities");
		File filePath = new File(fs, "original.apk");

		DesiredCapabilities cap = new DesiredCapabilities(); // creating an object of the class
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability(MobileCapabilityType.APP, filePath.getAbsolutePath()); // To get the absolute path of the
																					// application

		AndroidDriver<AndroidElement> and = new AndroidDriver<AndroidElement>(cap);
		return and;
	}

}
