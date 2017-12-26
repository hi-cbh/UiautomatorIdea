package com.uitest.testdemo;


import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.Ele;

public class MailDown  extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "MailDown";
		String testClass = "com.uitest.testdemo.MailDown";
		String testName = "testEmail";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
	
    public void testEmail() throws Exception{  

    	long times = System.currentTimeMillis();
    	
    	while(true){
        	//是否找到转圈控件
			if((Ele.waitForExistst(By.NAME, "加载更多邮件", 1) == null )){					
				DriverManager.swipeToUp();
				CommonUtil.sleep(500);
				DriverManager.swipeToUp();
				CommonUtil.sleep(500);
				DriverManager.swipeToUp();
			}
			else{
				CommonUtil.sleep(500);
				DriverManager.swipeToUp();
				CommonUtil.sleep(500);
				DriverManager.swipeToUp();
				Ele.waitForExistst(By.NAME, "加载更多邮件", 1).click();
				CommonUtil.sleep(500);
				DriverManager.swipeToUp();
				CommonUtil.sleep(500);
				DriverManager.swipeToUp();
				CommonUtil.sleep(500);
				DriverManager.swipeToUp();
			}
			
			if(System.currentTimeMillis()-times>2* 60  * 60 * 1000)
			{
				break;
			}
			if((Ele.waitForExistst(By.NAME, "已没有更多邮件", 1) != null )){
				break;	
			}
			Ele.waitForExistst(By.ID, "cn.cj.pe:id/message_list_bottom_email", 1).click();
			//休眠6秒
			CommonUtil.sleep(500);
    	}


    } 
	
}
