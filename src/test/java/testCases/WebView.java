package testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebView {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		File fs = new File("src/main/java/utilities");
		File filePath = new File(fs, "TheApp-v1.5.0.apk");

		DesiredCapabilities cap = new DesiredCapabilities(); // creating an object of the class
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability(MobileCapabilityType.APP, filePath.getAbsolutePath()); // To get the absolute path of the
																					// application

		AndroidDriver<AndroidElement> and = new AndroidDriver<AndroidElement>(cap);
		and.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		and.findElementByXPath(
				"//android.view.ViewGroup[@content-desc='Webview Demo']")
				.click();
		Thread.sleep(10000);
		
		System.out.println(and.getContext());
		and.context("WEBVIEW");
		
		and.findElementByName("//*[@name='EMAIL']").sendKeys("fsd");

	}

}
