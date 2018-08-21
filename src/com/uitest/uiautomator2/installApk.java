package com.uitest.uiautomator2;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.ElementManager;

public class installApk extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "installApk";
		String testClass = "com.uitest.uiautomator2.installApk";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testEmail() throws Exception {

		for (int i = 0; i < 3; i++) {
			if (ElementManager.waitForExistst(By.ID, "com.android.packageinstaller:id/permission_allow_button", 10) != null) {
				ElementManager.waitForExistst(By.ID,
						"com.android.packageinstaller:id/permission_allow_button", 5).click();
			}
			ADBUtil.sleep(1000);
		}

	}

}
