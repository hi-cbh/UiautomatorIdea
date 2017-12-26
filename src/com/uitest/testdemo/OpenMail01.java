package com.uitest.testdemo;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.ElementManager;

public class OpenMail01 extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "OpenMail01";
		String testClass = "com.uitest.testdemo.OpenMail01";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}


	/**
	 * 
	 * @throws UiObjectNotFoundException
	 * 
	 * @throws Exception
	 */
	public void testEmail() throws UiObjectNotFoundException {
		String appPackage = "cn.cj.pe"; // 程序的package
		String appActivity = "com.mail139.about.LaunchActivity"; // 程序的Activity

//		 long times = System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000; //
		 long times = System.currentTimeMillis() + 60 * 1000; //

			// 超时时间
			while (System.currentTimeMillis() < times) {

				System.out.println("adbStopApp");
				ADBUtil.adbStopApp("cn.cj.pe");
				// ADBUtil.sleep(2000);

				System.out.println("adbStartAPP");
				ADBUtil.adbStartAPP(appPackage, appActivity);
//				 ADBUtil.sleep(1000);
	
				 System.out.println("点击屏幕");
				 ADBUtil.tap(500, 500);
				 ADBUtil.sleep(1000);
				
				 System.out.println("点击屏幕");
				 ADBUtil.tap(500, 500);
				 ADBUtil.sleep(1000);
				 
				 System.out.println("点击屏幕");
				 ADBUtil.tap(500, 500);
				 ADBUtil.sleep(1000);

				System.out.println("点击屏幕");
				ADBUtil.tap(500, 500);
				ADBUtil.sleep(1000);
				
				if ((ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/hjl_headicon", 10) != null)) {
					ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/hjl_headicon", 1).click();
				}

				ADBUtil.adbHome();

				ADBUtil.sleep( 3 * 1000);
			}
	}
}
