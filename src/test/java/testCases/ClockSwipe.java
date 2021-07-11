package testCases;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClockSwipe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		File fs = new File("src/main/java/utilities");
		File filePath = new File(fs, "original1.apk");

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

		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

		driver.findElementByXPath("//*[@content-desc='9']").click();

		AndroidElement number15 = driver.findElementByXPath("//*[@content-desc='15']");
		AndroidElement number45 = driver.findElementByXPath("//*[@content-desc='45']");

		ta.longPress(longPressOptions().withElement(element(number15)).withDuration(ofSeconds(2)))
				.moveTo(element(number45)).release().perform();
		
	}

}
