package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class FireFoxBrowserLaunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DesiredCapabilities cap = new DesiredCapabilities(); // creating an object of the class
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Firefox");
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Gecko");
		cap.setCapability("geckodriverExecutable",
				"C:\\Users\\TJ\\Downloads\\gecko\\geckodriver.exe");

		AndroidDriver<AndroidElement> and = new AndroidDriver<AndroidElement>(cap);
		and.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		and.get("https://www.google.com");
		
	}

}
