package com.uitest.testdemo;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManager;

public class CopyOfOpenMail extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "CopyOfOpenMail";
		String testClass = "com.uitest.testdemo.CopyOfOpenMail";
		String testName = "testEmail";
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

		for (int i = 0; i < 100000; i++) {

			System.out.println("adbStopApp");
			ADBUtil.adbStopApp("cn.cj.pe");
			// ADBUtil.sleep(2000);

			System.out.println("adbStartAPP");
			ADBUtil.adbStartAPP(appPackage, appActivity);

			
			UiObject uo =  ElementManager.waitForExistst(By.NAME, "收件箱", 20);
			
			if(uo == null){
				ADBUtil.adbStopApp("cn.cj.pe");
				continue;
			}
			
			long times = System.currentTimeMillis() + 30 * 1000;

			// 超时时间
			while (System.currentTimeMillis() < times) {

				if ((ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/ad_pic", 2) != null)) {

					try {
						DriverManager.swipeToUp2();
						ADBUtil.sleep(1000);
						ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/ad_pic", 5)
								.click();
					} catch (Exception ue) {
						ADBUtil.adbStopApp("cn.cj.pe");
					}
					break;
				} else {
					DriverManager.swipeToUp();
				}
				ADBUtil.sleep(2 * 1000);

			}

			ADBUtil.sleep(5 * 1000);

		}

	}
}
