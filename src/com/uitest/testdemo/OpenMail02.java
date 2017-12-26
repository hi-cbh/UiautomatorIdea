package com.uitest.testdemo;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.uiautomatorUtil.TimeUtil;

public class OpenMail02 extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "OpenMail02";
		String testClass = "com.uitest.testdemo.OpenMail02";
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
	public void testEmail() throws Exception {
		String appPackage = "cn.cj.pe"; // 程序的package
		String appActivity = "com.mail139.about.LaunchActivity"; // 程序的Activity

			// 超时时间
			for (int i = 0; i< 32; i++) {

				ADBUtil.adbStopApp("cn.cj.pe");
				 ADBUtil.sleep(2000);

				ADBUtil.adbStartAPP(appPackage, appActivity);

				UiObject ob = ElementManager.waitForExistst(By.ID,"cn.cj.pe:id/tv_launch_count",5);
				String time1 = "";
				if (ob != null) {
					ADBUtil.tap(1288,120);
					time1 = TimeUtil.getCurrentSysTime();
				}

				ElementManager.waitForExistst(By.ID,"cn.cj.pe:id/message_list_bottom_email",10);
				String time2 = "";
				long valuetime = 0;
				if(!time1.equals("")){
					time2 = TimeUtil.getCurrentSysTime();
					valuetime = TimeUtil.getTimeDistance(time2, time1);
					System.out.println("time:"+valuetime/1000.0 +"");
				}

				ADBUtil.adbHome();

				ADBUtil.sleep( 1 * 1000);
			}
	}
}
