package com.uitest.testdemo;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;

public class Pic extends UiAutomatorTestCase{

	public static void main(String[] args) {
		String jarName = "test";
		String testClass = "com.uitest.testdemo.Pic";
		String testName = "test";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
	
	public void test() throws UiObjectNotFoundException{
	    //childselector
//      UiScrollable scrollable=new UiScrollable(new UiSelector()
//      .scrollable(true).childSelector(new UiSelector().text("Android")));     
//      scrollable.click();
    //formParent
	    UiObject parentObj=new UiObject(new UiSelector()
	    .resourceId("com.tencent.wstt.gt:id/cb_jiffies")
	    .fromParent(new UiSelector().className("android.widget.LinearLayout").index(1)));
	    parentObj.click();
	}
	
}
