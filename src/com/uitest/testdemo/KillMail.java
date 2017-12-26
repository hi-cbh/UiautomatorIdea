package com.uitest.testdemo;


import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.uiautomatorUtil.TimeUtil;

public class KillMail  extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "KillMail";
		String testClass = "com.uitest.testdemo.KillMail";
		String testName = "testEmail";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
	
    public void testEmail() throws Exception{  
    	String time1 = "";
    	String time2 = "";
    	String appPackage = "cn.cj.pe"; // 程序的package
    	String appActivity = "com.mail139.about.LaunchActivity"; // 程序的Activity
    	
    	long valuetime = 0;
    	for(int i = 0; i < 2; i++){
        	DriverManager.pressHome();
        	
        	ADBUtil.sleep(3000);
        	

        	ADBUtil.adbStartAPP(appPackage, appActivity);
        	
//        	UiObject uo =  ElementManager.waitForExistst(By.NAME, "139邮箱");
//        	
//        	time1 = TimeUtil.getCurrentSysTime();
//        	uo.click();
        	
        	ElementManager.waitForExistst(By.NAME, "收件箱", 30);
//        	time2 = TimeUtil.getCurrentSysTime();
        	
        	DriverManager.pressHome();
        
        	valuetime =  TimeUtil.getTimeDistance(time2, time1);
        	
//        	System.out.println("杀进程启动时间: " + (valuetime/1000.0) );
//        	UiautomatorAssistant.saveData("time: "+valuetime/1000.0);
        	
        	ADBUtil.sleep(2000);
        	
        	ADBUtil.adbStopApp("cn.cj.pe");
        	
        	ADBUtil.sleep(4*60*1000);
    	}


    } 
	
}
