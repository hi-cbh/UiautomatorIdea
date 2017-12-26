package com.uitest.testdemo;


import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.Ele;
import com.uitest.uiautomatorUtil.TimeUtil;

public class OpenMail  extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "OpenMail";
		String testClass = "com.uitest.testdemo.OpenMail";
		String testName = "";
		String androidId = UserConfig.androidId;
//		new UiAutomatorHelper(jarName, testClass, testName, androidId);
		String workPath = "/Users/apple/autoTest/workspace/UiautomatorIdea";
		new UiAutomatorHelper(jarName, testClass, testName, androidId,workPath,1);


	}
	
    public void testEmail() throws Exception{  

    	String time1 = "";
    	String time2 = "";
    	String time3 = "";
    	long valuetime = 0;
    	long valuetime2 = 0;
    	for(int i = 0; i < 32; i++){
    		System.out.println("tests: " + i);
        	DriverManager.pressHome();
        	
        	CommonUtil.sleep(3000);

        	UiObject uo =  Ele.waitForExistst(By.NAME, "139邮箱");
        	
        	time1 = TimeUtil.getCurrentSysTime();
        	uo.click();

			Ele.waitForExistst(By.ID,"cn.cj.pe:id/tv_launch_count",20);
			time3 = TimeUtil.getCurrentSysTime();

        	Ele.waitForExistst(By.NAME, "收件箱", 30);
        	time2 = TimeUtil.getCurrentSysTime();
        	
        	DriverManager.pressHome();
        
        	valuetime =  TimeUtil.getTimeDistance(time2, time1);
        	valuetime2 =  TimeUtil.getTimeDistance(time3, time1);

        	System.out.println("alltime:" + (valuetime/1000.0) );
        	System.out.println("findtime:" + (valuetime2/1000.0) );
        	//UiautomatorAssistant.saveData("time: "+valuetime/1000.0);
        	
        	CommonUtil.sleep(2000);
        	
        	CommonUtil.adbStopApp("cn.cj.pe");
        	
        	CommonUtil.sleep(2000);
    	}


    } 
	
}
