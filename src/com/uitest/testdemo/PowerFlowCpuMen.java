package com.uitest.testdemo;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.UiAutomatorHelper;
import com.mail.mode.power.PowerAction;
import com.mail.mode.ws360.FlowRecord360Action;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.DriverManager;

public class PowerFlowCpuMen extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "PowerFlowCpuMen";
		String testClass = "com.uitest.testdemo.PowerFlowCpuMen";
		String testName = "test";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	

	}
	/**
	 * 检测CPU、内存、电量消耗、流量等方法，可长时间运行不报错，替代appium（长时间容易报错）
	 * @throws Exception
	 */
	public void test() throws Exception{  
		String appPackage139 = "cn.cj.pe";
		String appPackage163 = "com.netease.mail"; 
		String appPackageqq = "com.tencent.androidqqmail";
		String appPackage189 = "com.corp21cn.mail189";
		String appPackage360 = "com.qihoo360.mobilesafe"; // 程序的package
		String appActivity360 = "com.qihoo360.mobilesafe.ui.index.AppEnterActivity"; // 360程序的Activity
		String networkType = CommonUtil.getNetworkType();
		CommonUtil.sleep(3000);
		DriverManager.pressHome();
		
		String pid = "";
		String testApp = appPackage139;
		String testtxt = "139邮箱";
		

		System.out.println("静等待5分钟.....");
		for(int j = 0; j < 5; j++){
			System.out.println("等待分钟: "+ (j+1));
			CommonUtil.sleep(1*60*1000);
		}
		
		System.out.println("准备测试环境。");
		
//		GTTest gt = new GTTest(testApp);

		for(int i =0; i<1; i++){
			CommonUtil.sleep(3000);
			PowerAction.execute();
//			gt.startGT();
			FlowRecord360Action.executePreset();
			CommonUtil.sleep(3000);
			System.out.println("等待30分钟.....");
			for(int j = 0; j < 30; j++){
				System.out.println("等待分钟: "+ (j+1));
				CommonUtil.sleep(1*60*1000);

				if(j+1  == 15 || j+1  == 20 || j+1  == 25){
					System.out.println("准备发邮件....");
//					CommonUtil.cmdLine("am broadcast -a my.email.broadcast");
				}
			}
			System.out.println("开始记录.....");
			PowerAction.execute2();
//			UiautomatorAssistant.saveData("CPU#内存峰值：" + gt.endGT());
			FlowRecord360Action.executeRecord(testtxt,networkType, true);
			
			
			System.out.println("kill 电量监测工具");
			CommonUtil.sleep(3000);
			CommonUtil.adbStopApp("edu.umich.PowerTutor");
			CommonUtil.adbStopApp(appPackage360);

			
		}	
		
	}
}
