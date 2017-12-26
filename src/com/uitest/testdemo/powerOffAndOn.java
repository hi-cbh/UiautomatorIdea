package com.uitest.testdemo;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.Ele;

import com.uitest.uiautomatorUtil.DriverManager;

public class powerOffAndOn extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "powerOffAndOn";
		String testClass = "com.uitest.testdemo.powerOffAndOn";
		String testName = "";
		String androidId = UserConfig.androidId;
		String workPath = "/Users/apple/autoTest/workspace/UiautomatorIdea";
		new UiAutomatorHelper(jarName, testClass, testName, androidId,workPath,1);
	}

	public void testPower() throws Exception {
		if (UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().sleep();
		}
		CommonUtil.sleep(2000);

		UiDevice.getInstance().wakeUp();

		DriverManager.swipe(0,2300,1430,2300);
		CommonUtil.sleep(2000);

	}

}
