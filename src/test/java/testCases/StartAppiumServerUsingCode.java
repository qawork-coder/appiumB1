package testCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartAppiumServerUsingCode {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		File fs = new File("src/main/java/utilities");
		File filePath = new File(fs, "original.apk");

		AndroidDriver<AndroidElement> driver;
		AppiumDriverLocalService service;

		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		String appiumURL = service.getUrl().toString();

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability(MobileCapabilityType.APP, filePath.getAbsolutePath());

		driver = new AndroidDriver<AndroidElement>(new URL(appiumURL), cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		service.stop();

	}

}
