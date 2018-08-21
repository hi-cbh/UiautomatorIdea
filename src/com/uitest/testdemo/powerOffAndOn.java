package com.uitest.testdemo;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;

import com.uitest.uiautomatorUtil.DriverManager;

public class powerOffAndOn extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "powerOffAndOn";
		String testClass = "com.uitest.testdemo.powerOffAndOn";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testPower() throws Exception {
		if (UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().sleep();
		}
		ADBUtil.sleep(2000);

		UiDevice.getInstance().wakeUp();

//		DriverManager.swipe(0,2300,1430,2300);
		DriverManager.swipe(0,1000,1430,1000);
		ADBUtil.sleep(2000);

	}

}
