package testCases;

import base.BaseSetup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UsagaeOfBaseGetDriverMethod  extends BaseSetup{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> dr=getAndroidDriver();
		dr.findElementByXPath("//android.widget.TextView[@content-desc='Accessibility']").click();
	}

}
