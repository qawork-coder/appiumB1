package testCases;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Scrolling {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File fs = new File("src/main/java/utilities");
		File filePath = new File(fs, "original.apk");

		DesiredCapabilities cap = new DesiredCapabilities(); // creating an object of the class
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability(MobileCapabilityType.APP, filePath.getAbsolutePath()); // To get the absolute path of the
																					// application

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		TouchAction ta = new TouchAction(driver);

		// Tap options
		AndroidElement tapOptionElement = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		ta.tap(tapOptions().withElement(element(tapOptionElement))).perform();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
        
        //Copy the file to a location and use try catch block to handle exception
    
       FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshoddt.png"));
	}

}
