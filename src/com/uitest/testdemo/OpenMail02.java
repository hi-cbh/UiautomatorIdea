package com.uitest.testdemo;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.Ele;
import com.uitest.uiautomatorUtil.TimeUtil;

public class OpenMail02 extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "OpenMail02";
		String testClass = "com.uitest.testdemo.OpenMail02";
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
	public void testEmail() throws Exception {
		String appPackage = "cn.cj.pe"; // 程序的package
		String appActivity = "com.mail139.about.LaunchActivity"; // 程序的Activity
		// CommonUtil.adbStartAPP(appPackage, appActivity);
		// CommonUtil.sleep(2000);
		//
		// DriverManager.pressHome();
		// CommonUtil.sleep(2000);


			// 超时时间
			for (int i = 0; i< 32; i++) {

//				System.out.println("adbStopApp");
				CommonUtil.adbStopApp("cn.cj.pe");
				 CommonUtil.sleep(2000);

//				System.out.println("adbStartAPP");
				CommonUtil.adbStartAPP(appPackage, appActivity);

				UiObject ob = Ele.waitForExistst(By.ID,"cn.cj.pe:id/tv_launch_count",5);
				String time1 = "";
				if (ob != null) {
//					System.out.println("click()");
//					ob.click();
//					CommonUtil.tap(980,120);
//					CommonUtil.tap(940,100);
					CommonUtil.tap(1288,120);
					time1 = TimeUtil.getCurrentSysTime();
				}

				Ele.waitForExistst(By.ID,"cn.cj.pe:id/message_list_bottom_email",10);
				String time2 = "";
				long valuetime = 0;
				if(!time1.equals("")){
					time2 = TimeUtil.getCurrentSysTime();
					valuetime = TimeUtil.getTimeDistance(time2, time1);
					System.out.println("time:"+valuetime/1000.0 +"");
				}

				CommonUtil.adbHome();

				CommonUtil.sleep( 1 * 1000);
			}
	}
}
