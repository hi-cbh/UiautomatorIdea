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
 * 点击详情页，查看是否显示空白，返回后，页面是否显示转圈
 * 转圈测试
 */
public class loadEmail extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "loadEmail";
		String testClass = "com.uitest.testdemo.loadEmail";
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
			for (int i = 0; i < 100000; i++) {
				runMonkey();
			}

		}catch (Exception e){
			testEmail();
		}

	}


	public void runMonkey() throws UiObjectNotFoundException {

		for(int j = 0; j < 20; j++){
			if((ElementManager.waitForExistst(By.NAME, "加载更多", 1) == null )){
				DriverManager.swipeToUp();
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
			}
			else{
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
				ElementManager.waitForExistst(By.NAME, "加载更多", 1).click();
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
			}
		}
	}



}


