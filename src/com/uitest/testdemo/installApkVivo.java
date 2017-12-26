package com.uitest.testdemo;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.Ele;

/**
 * 用于vivo37
 * @author Administrator
 *
 */

public class installApkVivo extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "installApkVivo";
		String testClass = "com.uitest.testdemo.installApkVivo";
		String testName = "testEmail";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testEmail() throws Exception {

		for (int i = 0; i < 3; i++) {
			if (Ele.waitForExistst(By.ID, "android:id/button1",
					10) != null) {
				Ele.waitForExistst(By.ID,
						"android:id/button1", 5).click();
				
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
