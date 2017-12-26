package com.uitest.testdemo;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.Ele;

public class CopyOfOpenMail extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "CopyOfOpenMail";
		String testClass = "com.uitest.testdemo.CopyOfOpenMail";
		String testName = "testEmail";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	// /**
	// * 对数测试 13501538531 139chinasofti 13501538531  139chinasofti
	// * 13580491687  139chinasoft 13580491573  139chinasofti
	// * 13533218540  139chinasofti
	// *
	// * @throws Exception
	// */
	// public void testEmail1() {
	// String appPackage = "cn.cj.pe"; // 程序的package
	// String appActivity = "com.mail139.about.LaunchActivity"; // 程序的Activity
	// CommonUtil.adbStartAPP(appPackage, appActivity);
	// CommonUtil.sleep(2000);
	//
	// DriverManager.pressHome();
	// CommonUtil.sleep(2000);
	//
	// for (int i = 0; i < 3000; i++) {
	//
	// System.out.println("adbStopApp");
	// CommonUtil.adbStopApp("cn.cj.pe");
	//
	// CommonUtil.sleep(2000);
	// System.out.println("点击【139邮箱】");
	//
	// try {
	// Ele.waitForExistst(By.NAME, "139邮箱").click();
	// } catch (UiObjectNotFoundException e1) {
	// CommonUtil.adbStopApp("cn.cj.pe");
	// testEmail();
	// }
	//
	// CommonUtil.sleep(2000);
	//
	// System.out.println("点击屏幕");
	// CommonUtil.tap(500, 500);
	//
	// UiautomatorAssistant.saveData(TimeUtil.getCurrentSysTimeLog()
	// + " 第 " + i + " 次添加屏幕");
	//
	// UiObject uo = null;
	// try {
	// if (Ele.waitForExistst(By.Description, "知道了", 30) == null) {
	// System.out.println("找不到，点击坐标");
	// CommonUtil.tap(540, 1300);
	// } else {
	// uo = Ele.waitForExistst(By.Description, "知道了", 5);
	// CommonUtil.sleep(2000);
	// System.out.println("点击【知道了】");
	// uo.click();
	// }
	// } catch (UiObjectNotFoundException e) {
	// CommonUtil.adbStopApp("cn.cj.pe");
	// testEmail();
	// }
	//
	// CommonUtil.sleep(2000);
	// System.out.println("点击【关闭】");
	//
	// UiObject uo1 = null;
	// try {
	// if (Ele.waitForExistst(By.ID, "cn.cj.pe:id/hjl_headicon", 20) == null) {
	// System.out.println("找不到，点击坐标");
	// CommonUtil.tap(1000, 140);
	// } else {
	// uo1 = Ele.waitForExistst(By.ID, "cn.cj.pe:id/hjl_headicon",
	// 5);
	// CommonUtil.sleep(2000);
	// uo1.click();
	// }
	// } catch (UiObjectNotFoundException e) {
	// CommonUtil.adbStopApp("cn.cj.pe");
	// testEmail();
	// }
	//
	// System.out.println("等待收件箱");
	// try {
	// if (Ele.waitForExistst(By.NAME, "收件箱", 10) == null) {
	// System.out.println("找不到，点击坐标");
	// CommonUtil.adbStopApp("cn.cj.pe");
	// } else {
	// DriverManager.pressHome();
	// CommonUtil.sleep(2000);
	// System.out.println("完成当次测试");
	// }
	// } catch (Exception e) {
	// CommonUtil.adbStopApp("cn.cj.pe");
	// testEmail();
	// }
	//
	// }
	//
	// }

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

		for (int i = 0; i < 100000; i++) {

			System.out.println("adbStopApp");
			CommonUtil.adbStopApp("cn.cj.pe");
			// CommonUtil.sleep(2000);

			System.out.println("adbStartAPP");
			CommonUtil.adbStartAPP(appPackage, appActivity);
			// CommonUtil.sleep(1000);

//			 System.out.println("点击屏幕");
//			 CommonUtil.tap(500, 500);
//			
//			 Ele.waitForExistst(By.ID, "cn.cj.pe:id/hjl_headicon",10);
//			 CommonUtil.sleep(5*1000);

			
			
			UiObject uo =  Ele.waitForExistst(By.NAME, "收件箱", 20);
			
			if(uo == null){
				CommonUtil.adbStopApp("cn.cj.pe");
				continue;
			}
			
			long times = System.currentTimeMillis() + 30 * 1000;

			// 超时时间
			while (System.currentTimeMillis() < times) {

				if ((Ele.waitForExistst(By.ID, "cn.cj.pe:id/ad_pic", 2) != null)) {

					try {
						DriverManager.swipeToUp2();
						CommonUtil.sleep(1000);
						Ele.waitForExistst(By.ID, "cn.cj.pe:id/ad_pic", 5)
								.click();
					} catch (Exception ue) {
						CommonUtil.adbStopApp("cn.cj.pe");
					}
					break;
				} else {
					DriverManager.swipeToUp();
				}
				CommonUtil.sleep(2 * 1000);

			}

			CommonUtil.sleep(5 * 1000);

			// cn.cj.pe:id/ad_pic

			// UiautomatorAssistant.saveData(TimeUtil.getCurrentSysTimeLog()
			// + " 第 " + i + " 次添加屏幕");
			//
			// System.out.println("点击【关闭】");
			// Ele.waitForExistst(By.ID, "cn.cj.pe:id/hjl_headicon",10).click();
			//
			// CommonUtil.sleep(2*1000);

		}

	}
}
