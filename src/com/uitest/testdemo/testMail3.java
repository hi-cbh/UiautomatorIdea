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


/**
 * 切换侧边栏文件夹，多次切换后，返回收件箱，如果出现转圈一分钟，停止
 * 转圈测试
 */
public class testMail3 extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "CopyOfOpenMail";
		String testClass = "com.uitest.testdemo.testMail3";
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
		try{
			for (int i = 0; i < 10000000; i++) {

				System.out.println("adbStopApp");
				ADBUtil.adbStopApp("cn.cj.pe");
				// ADBUtil.sleep(2000);

				String appPackage = "cn.cj.pe"; // 程序的package
				String appActivity = "com.mail139.about.LaunchActivity"; // 程序的Activity

				System.out.println("adbStartAPP");
				ADBUtil.adbStartAPP(appPackage, appActivity);


				UiObject uo =  ElementManager.waitForExistst(By.NAME, "收件箱", 20);

				if(uo == null){
					ADBUtil.adbStopApp("cn.cj.pe");
					continue;
				}
				//休眠5秒
				System.out.println("休眠5秒");
				ADBUtil.sleep(5 * 1000);

				for(int j=8; j>=0; j--){
					ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/actionbar_left_view",5).click();
					ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/content_layout",5,j).click();

				}

				//判断是否在转圈，如果不转圈，进入下一轮
				if ((ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/refresh_quee_view", 2) == null)) {
					System.out.println("转圈不存在");
					continue;
				}

				System.out.println("进入判断转圈时间");
				long times = System.currentTimeMillis() + 10 * 60 * 1000;
				// 超时时间
				while (System.currentTimeMillis() < times) {
					System.out.println("判断转圈是否存在，如果存在，继续下一次");
					//判断转圈是否存在，如果存在，继续下一次
					if ((ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/refresh_quee_view", 2) == null)) {
						System.out.println("转圈不存在，跳出循环");
						break;
					}
					ADBUtil.sleep(10 * 1000);
				}
				System.out.println("判断转圈是否存在，如果存在，跳出");
				if ((ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/refresh_quee_view", 2) != null)) {
					System.out.println("转圈存在，跳出循环");
					break;
				}
				ADBUtil.sleep(5 * 1000);
			}
		}catch (Exception e){
			testEmail();
		}
	}

}


