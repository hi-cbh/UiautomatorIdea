package com.uitest.testdemo;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.Ele;

public class installApk extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "installApk";
		String testClass = "com.uitest.testdemo.installApk";
		String testName = "";
		String androidId = UserConfig.androidId;
		String workPath = "/Users/apple/autoTest/workspace/UiautomatorRunProject";
		new UiAutomatorHelper(jarName, testClass, testName, androidId,workPath,1);
	}

	public void testEmail() throws Exception {

		for (int i = 0; i < 3; i++) {
			if (Ele.waitForExistst(By.ID, "vivo:id/vivo_adb_install_app_name", 10) != null) {
				String str = Ele.waitForExistst(By.ID,
						"vivo:id/vivo_adb_install_app_name", 10).getText();

				if (str.contains("Appium") || str.contains("Unlock")) {
					Ele.waitForExistst(By.ID,
							"vivo:id/vivo_adb_install_ok_button", 5).click();
				}
			}
			CommonUtil.sleep(2000);
		}

	}

}
