package com.uitest.testdemo;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.log.UiautomatorAssistant;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.uiautomatorUtil.ImageManager;

public class SendEmail extends UiAutomatorTestCase {


		public static void main(String[] args) {
			String jarName = "SendEmail";
			String testClass = "com.uitest.testdemo.SendEmail";
			String testName = "test";
			String androidId = UserConfig.androidId;
			new UiAutomatorHelper(jarName, testClass, testName, androidId);
		
		}
		/**
		 * 发送邮件，检测是否发送成功
		 * @throws Exception
		 */
		public void test() throws Exception{  
	    	String appPackage = "cn.cj.pe"; // 程序的package
	    	String appActivity = "com.mail139.about.LaunchActivity"; // 程序的Activity
	    	int success = 0;
	    	int fail = 0;
	    	
	    	for(int i = 0; i< 150; i++){

	        	ADBUtil.adbStopApp("cn.cj.pe");
	        	
	        	ADBUtil.adbStartAPP(appPackage, appActivity);
	        	
	        	ElementManager.waitForExistst(By.NAME, "收件箱", 20);
	        	
	        	ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/actionbar_right_view").click();
	        	
	        	ADBUtil.sleep(15000);
	        	
	        	ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/to_layout", 10).setText("138000@139.com");
	        	
	        	ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/subject", 10).setText("test");
	        	
	        	ADBUtil.sleep(15000);
	        	
				ElementManager.waitForExistst(By.NAME, "发送").click();
				
				UiObject uo  = ElementManager.waitForExistst(By.NAME, "已完成", 10);
				
				if(uo != null){
					System.out.println("发送成功");
					UiautomatorAssistant.saveData("发送成功，显示已发送次数为：" + (success+1));
					ImageManager.snapshot("SendSuccess"+(success+1), "send_success");
					success++;
				}
				else{
					System.out.println("发送失败");
					UiautomatorAssistant.saveData("发送失败，显示发送失败次数为：" + (fail+1));
					ImageManager.snapshot("SendFail"+ (fail+1), "send_fail");
					fail++;
				}
				
				ADBUtil.sleep(15000);
	    	}
	   
		}
}
