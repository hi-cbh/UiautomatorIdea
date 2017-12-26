package com.uitest.testdemo;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.Ele;

public class installApk2 extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "installApk2";
		String testClass = "com.uitest.testdemo.installApk2";
		String testName = "testEmail";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testEmail() throws Exception {

		for (int i = 0; i < 1; i++) {
			if (Ele.waitForExistst(By.ID, "vivo:id/vivo_adb_install_app_name", 20) != null) {
				String str = Ele.waitForExistst(By.ID,
						"vivo:id/vivo_adb_install_app_name", 10).getText();

				if (str.contains("139邮箱")) {
					Ele.waitForExistst(By.ID,
							"vivo:id/vivo_adb_install_ok_button", 5).click();
				}
			}
			CommonUtil.sleep(2000);
		}

	}

}
