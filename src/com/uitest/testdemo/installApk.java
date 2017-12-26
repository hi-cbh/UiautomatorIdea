package com.uitest.testdemo;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.ElementManager;

public class installApk extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "installApk";
		String testClass = "com.uitest.testdemo.installApk";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testEmail() throws Exception {

		for (int i = 0; i < 3; i++) {
			if (ElementManager.waitForExistst(By.ID, "vivo:id/vivo_adb_install_app_name", 10) != null) {
				String str = ElementManager.waitForExistst(By.ID,
						"vivo:id/vivo_adb_install_app_name", 10).getText();

				if (str.contains("Appium") || str.contains("Unlock")) {
					ElementManager.waitForExistst(By.ID,
							"vivo:id/vivo_adb_install_ok_button", 5).click();
				}
			}
			ADBUtil.sleep(2000);
		}

	}

}
