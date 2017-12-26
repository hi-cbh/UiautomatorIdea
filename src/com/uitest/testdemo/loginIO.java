package com.uitest.testdemo;


import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.Ele;

/**
 * 一键登录及退出
 */
public class loginIO extends UiAutomatorTestCase {
    public static void main(String[] args) {
        String jarName = "loginIO";
        String testClass = "com.uitest.testdemo.loginIO";
        String testName = "";
        String androidId = UserConfig.androidId;
        String workPath = "/Users/apple/autoTest/workspace/UiautomatorIdea";
        new UiAutomatorHelper(jarName, testClass, testName, androidId,workPath,1);

//		new UiAutomatorHelper(jarName, testClass, testName, androidId);
    }


    public void testLogin() throws UiObjectNotFoundException{
        System.out.println("start");
        String appPackage = "cn.cj.pe"; // 程序的package
        String appActivity = "com.mail139.about.LaunchActivity"; //


        for(int i=0; i< 100; i++){
            CommonUtil.adbHome();
            CommonUtil.sleep(2000);


            CommonUtil.adbStopApp(appPackage);
            CommonUtil.sleep(2000);

            CommonUtil.adbStartAPP(appPackage,appActivity);
            CommonUtil.sleep(6000);

            // 退出
            Ele.waitForExistst(By.NAME,"我的",3).click();
            CommonUtil.sleep(2000);

//            Ele.waitForExistst(By.NAME,"设置",3).click();
            CommonUtil.tap(500,1530);
            CommonUtil.sleep(2000);

            Ele.waitForExistst(By.ID,"cn.cj.pe:id/account_name",3).click();
            CommonUtil.sleep(2000);

            Ele.waitForExistst(By.NAME,"退出账号",3).click();
            CommonUtil.sleep(2000);

            Ele.waitForExistst(By.NAME,"确定",3).click();


            CommonUtil.sleep(3000);
            //login
            Ele.waitForExistst(By.NAME,"快速登录",5).click();

            CommonUtil.sleep(2000*60);
        }





    }

}
