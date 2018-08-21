package com.uitest.testdemo;


import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManager;

public class MailDown2 extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "MailDown";
		String testClass = "com.uitest.testdemo.MailDown2";
		String testName = "testEmail";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
	
    public void testEmail() throws Exception{
		DriverManager.swipeToDown();
		ADBUtil.sleep(500);
		DriverManager.swipeToDown();
		ADBUtil.sleep(500);
		DriverManager.swipeToDown();
    } 
	
}
