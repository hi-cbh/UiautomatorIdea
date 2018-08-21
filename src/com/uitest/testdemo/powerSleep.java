package com.uitest.testdemo;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.DriverManager;

public class powerSleep extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "powerSleep";
		String testClass = "com.uitest.testdemo.powerSleep";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testPower() throws Exception {
		if (UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().sleep();
		}

	}

}


