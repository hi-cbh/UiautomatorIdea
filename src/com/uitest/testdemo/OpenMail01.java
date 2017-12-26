package com.uitest.testdemo;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.Ele;

public class OpenMail01 extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "OpenMail01";
		String testClass = "com.uitest.testdemo.OpenMail01";
		String testName = "";
		String androidId = UserConfig.androidId;
		String workPath = "/Users/apple/autoTest/workspace/UiautomatorIdea";
		new UiAutomatorHelper(jarName, testClass, testName, androidId,workPath,1);

//		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}


	/**
	 * 对数测试 13501538531 139chinasofti 13501538531  139chinasofti
	 * 13580491687  139chinasoft 13580491573  139chinasofti
	 * 13533218540  139chinasofti
	 * 
	 * @throws UiObjectNotFoundException
	 * 
	 * @throws Exception
	 */
	public void testEmail() throws UiObjectNotFoundException {
		String appPackage = "cn.cj.pe"; // 程序的package
		String appActivity = "com.mail139.about.LaunchActivity"; // 程序的Activity
		// CommonUtil.adbStartAPP(appPackage, appActivity);
		// CommonUtil.sleep(2000);
		//
		// DriverManager.pressHome();
		// CommonUtil.sleep(2000);

		 long times = System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000; //
//		 long times = System.currentTimeMillis() + 60 * 1000; //

			// 超时时间
			while (System.currentTimeMillis() < times) {

				System.out.println("adbStopApp");
				CommonUtil.adbStopApp("cn.cj.pe");
				// CommonUtil.sleep(2000);

				System.out.println("adbStartAPP");
				CommonUtil.adbStartAPP(appPackage, appActivity);
//				 CommonUtil.sleep(1000);
	
				 System.out.println("点击屏幕");
				 CommonUtil.tap(500, 500);
				 CommonUtil.sleep(1000);
				
				 System.out.println("点击屏幕");
				 CommonUtil.tap(500, 500);
				 CommonUtil.sleep(1000);
				 
				 System.out.println("点击屏幕");
				 CommonUtil.tap(500, 500);
				 CommonUtil.sleep(1000);

				System.out.println("点击屏幕");
				CommonUtil.tap(500, 500);
				CommonUtil.sleep(1000);
				
				if ((Ele.waitForExistst(By.ID, "cn.cj.pe:id/hjl_headicon", 10) != null)) {
					Ele.waitForExistst(By.ID, "cn.cj.pe:id/hjl_headicon", 1).click();
				}

				CommonUtil.adbHome();

				CommonUtil.sleep( 3 * 1000);
			}
	}
}
