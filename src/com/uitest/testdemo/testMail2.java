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
public class testMail2 extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "CopyOfOpenMail";
		String testClass = "com.uitest.testdemo.testMail2";
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
			for (int i = 0; i < 1000000000; i++) {

				System.out.println("adbStopApp");
				ADBUtil.adbStopApp("cn.cj.pe");
				// ADBUtil.sleep(2000);

				String appPackage = "cn.cj.pe"; // 程序的package
				String appActivity = "com.mail139.about.LaunchActivity"; // 程序的Activity


				runAPP();





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


				if(ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/sender",2,2) !=null){
					ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/sender",2,2).click();
				}


				ADBUtil.sleep(5*1000);

				if(ElementManager.waitForExistst(By.ID,"cn.cj.pe:id/title",2) != null){
					ADBUtil.adbBack();
					ADBUtil.sleep(2*1000);
				}
				else{

					System.out.println("进入判断转圈时间");
					long times = System.currentTimeMillis() + 10 * 60 * 1000;
					long times2 = System.currentTimeMillis();
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

				}




				//判断是否在转圈，如果不转圈，进入下一轮
				if ((ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/refresh_quee_view", 2) == null)) {
					System.out.println("转圈不存在");
					continue;
				}

				System.out.println("进入判断转圈时间");
				long times = System.currentTimeMillis() + 10 * 60 * 1000;
				long times2 = System.currentTimeMillis();
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


//
//				System.out.println("大于9分钟");
//				if(times2 - System.currentTimeMillis() >= 8 * 60 * 1000){
//
//					System.out.println("这里需要发送广播");
//					//发送其他广播
//					ADBUtil.adbBroadcast();
//					FileManager.saveToFile("email.log",TimeUtil.getCurrentSysTimeRunTime()+": send adbBroadcast");
//					//这里发送邮件,发送广播发邮件
//					ADBUtil.adbBroadcastMy();
//					//adb shell am broadcast -a myemailbroadcast


//				}

				ADBUtil.sleep(5 * 1000);




			}

		}catch (Exception e){
			testEmail();
		}
//		FileManager.saveToFile("email.log",TimeUtil.getCurrentSysTimeRunTime()+": send adbBroadcast");
		//这里发送邮件,发送广播发邮件
//		ADBUtil.adbBroadcastMy();


	}

	public void runAPP() throws UiObjectNotFoundException {
		for(int i=1; i<7; i++){
			ElementManager.waitForExistst(By.NAME, "Test内存"+i, 1).click();
			ADBUtil.sleep(3);
			ADBUtil.adbHome();
		}





	}

	public void runMonkey() throws UiObjectNotFoundException {

		for(int j = 0; j < 20; j++){
			if((ElementManager.waitForExistst(By.NAME, "加载更多邮件", 1) == null )){
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
				ElementManager.waitForExistst(By.NAME, "加载更多邮件", 1).click();
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
				ADBUtil.sleep(500);
				DriverManager.swipeToUp();
			}
		}


		if(ElementManager.waitForExistst(By.ID,"cn.cj.pe:id/sender",10) != null){
			ElementManager.waitForExistst(By.ID,"cn.cj.pe:id/sender",1).click();
		}

		ADBUtil.sleep(2000);
		if(ElementManager.waitForExistst(By.ID,"cn.cj.pe:id/title",5) == null){
			System.out.println("这里需要发送广播");
			//发送其他广播
//			ADBUtil.adbBroadcast();
//			FileManager.saveToFile("email.log",TimeUtil.getCurrentSysTimeRunTime()+": send adbBroadcast");
//			//这里发送邮件,发送广播发邮件
//			ADBUtil.adbBroadcastMy();
//			adb shell am broadcast -a myemailbroadcast
		}

		ADBUtil.adbBack();
		ADBUtil.sleep(5000);


	}

	public void clear() throws UiObjectNotFoundException{


		ElementManager.waitForExistst(By.NAME, "我的", 20).click();
		ElementManager.waitForExistst(By.NAME, "设置", 20).click();
		ElementManager.waitForExistst(By.NAME, "设置", 20).click();

		DriverManager.swipeToUp();

		ElementManager.waitForExistst(By.NAME, "清理缓存", 20).click();
		ElementManager.waitForExistst(By.NAME, "清理所有邮箱已下载邮件", 20).click();
		ElementManager.waitForExistst(By.NAME, "确定", 20).click();

		ADBUtil.sleep(10000);

		ADBUtil.adbBack();
		ADBUtil.sleep(2000);
		ADBUtil.adbBack();

		ElementManager.waitForExistst(By.ID, "cn.cj.pe:id/message_list_bottom_email", 20).click();
	}

}


