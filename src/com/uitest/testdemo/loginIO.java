package com.uitest.testdemo;


import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.ElementManager;

/**
 * 一键登录及退出
 */
public class loginIO extends UiAutomatorTestCase {
    public static void main(String[] args) {
        String jarName = "loginIO";
        String testClass = "com.uitest.testdemo.loginIO";
        String testName = "";
        String androidId = UserConfig.androidId;
        new UiAutomatorHelper(jarName, testClass, testName, androidId);
    }


    public void testLogin() throws UiObjectNotFoundException{
        System.out.println("start");
        String appPackage = "cn.cj.pe"; // 程序的package
        String appActivity = "com.mail139.about.LaunchActivity"; //


        for(int i=0; i< 100; i++){
            ADBUtil.adbHome();
            ADBUtil.sleep(2000);


            ADBUtil.adbStopApp(appPackage);
            ADBUtil.sleep(2000);

            ADBUtil.adbStartAPP(appPackage,appActivity);
            ADBUtil.sleep(6000);

            // 退出
            ElementManager.waitForExistst(By.NAME,"我的",3).click();
            ADBUtil.sleep(2000);

//            ElementManager.waitForExistst(By.NAME,"设置",3).click();
            ADBUtil.tap(500,1530);
            ADBUtil.sleep(2000);

            ElementManager.waitForExistst(By.ID,"cn.cj.pe:id/account_name",3).click();
            ADBUtil.sleep(2000);

            ElementManager.waitForExistst(By.NAME,"退出账号",3).click();
            ADBUtil.sleep(2000);

            ElementManager.waitForExistst(By.NAME,"确定",3).click();


            ADBUtil.sleep(3000);
            //login
            ElementManager.waitForExistst(By.NAME,"快速登录",5).click();

            ADBUtil.sleep(2000*60);
        }





    }

}
