package testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File fs = new File("src/main/java/utilities");
		File filePath = new File(fs, "original.apk");

		DesiredCapabilities cap = new DesiredCapabilities(); // creating an object of the class
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability(MobileCapabilityType.APP, filePath.getAbsolutePath()); // To get the absolute path of the
																					// application

		AndroidDriver<AndroidElement> and = new AndroidDriver<AndroidElement>(cap);
		and.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		File scrFile = ((TakesScreenshot) and).getScreenshotAs(OutputType.FILE); //raw format
		FileUtil.copyFile(scrFile, new File("C:\\appium\\tj.jpg"));

	}

}
