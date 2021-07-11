package testCases;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TouchActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File fs = new File("src/main/java/utilities");
		File filePath = new File(fs, "original.apk");

		DesiredCapabilities cap = new DesiredCapabilities(); // creating an object of the class
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability(MobileCapabilityType.APP, filePath.getAbsolutePath()); // To get the absolute path of the
																					// application

		AndroidDriver<AndroidElement> and = new AndroidDriver<AndroidElement>(cap);

		TouchAction touchObject = new TouchAction(and);

		AndroidElement tapOptionElement = and.findElementByXPath("//android.widget.TextView[@text='Views']");

		touchObject.tap(tapOptions().withElement(element(tapOptionElement))).perform();
		and.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

		AndroidElement longPressElement1 = and.findElementsByClassName("android.view.View").get(0);
		AndroidElement longPressElement2 = and.findElementsByClassName("android.view.View").get(1);
		// ta.longPress(longPressOptions().withElement(element(longPressElement1)).withDuration(ofSeconds(2))).release().moveTo(element(longPressElement2)).release().perform();
		// OR the below one
		touchObject.longPress((element(longPressElement1))).release().moveTo(element(longPressElement2)).release()
				.perform();
	}

}
