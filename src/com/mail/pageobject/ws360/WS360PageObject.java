package com.mail.pageobject.ws360;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.donot.change.By;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.Ele;
import com.uitest.uiautomatorUtil.ImageManager;


public class WS360PageObject {

	/**
	 * 点击取消
	 * 
	 * @param driver
	 * @throws UiObjectNotFoundException 
	 */
	public void clickPrivacyButton() throws UiObjectNotFoundException {

		Ele.waitForExistst(By.ID,"com.qihoo360.mobilesafe:id/btn_privacy_confirm")
				.click();
		CommonUtil.sleep(2000);
	}

	public void clickLeftButton() throws UiObjectNotFoundException {
		
		if(Ele.waitForExistst(
				By.ID,"com.qihoo360.mobilesafe:id/common_btn_left", 5)!= null){
			Ele.waitForExistst(
					By.ID,"com.qihoo360.mobilesafe:id/common_btn_left", 5).click();
		}
		

		if(Ele.waitForExistst(
				By.ID,"com.qihoo360.mobilesafe:id/common_btn_left", 5)!= null){
			Ele.waitForExistst(
					By.ID,"com.qihoo360.mobilesafe:id/common_btn_left", 5).click();
		}
		CommonUtil.sleep(2000);
	}

	/**
	 * 点击话费与流量
	 * 
	 * @param driver
	 * @throws UiObjectNotFoundException 
	 */
	public void clickBillandFlow() throws UiObjectNotFoundException {
		Ele.waitForExistst( By.NAME,"话费•流量").click();
	}

	/**
	 * 点击软件流量管理
	 * 
	 * @param driver
	 * @throws UiObjectNotFoundException 
	 */
	public void clickFlowManager() throws UiObjectNotFoundException {
		Ele.waitForExistst( By.NAME,"软件流量管理").click();
	}

	/**
	 * 点击 2G/3G/4G消耗
	 * 
	 * @param driver
	 * @throws UiObjectNotFoundException 
	 */
	public void clickGFlow() throws UiObjectNotFoundException {
		Ele.waitForExistst( By.NAME,"2G/3G/4G消耗")
				.click();
	}

	/**
	 * 点击 监控消耗类型
	 * @param driver
	 * @throws UiObjectNotFoundException 
	 */
	public void clickFlowStype() throws UiObjectNotFoundException {
		UiObject e = Ele.getUiObject(By.ID, "com.qihoo360.mobilesafe:id/common_popbtns", By.CLASSNAME, "android.widget.TextView", 1);
		
		if(e != null){
			e.click();
			
		}else{
			System.out.println("clickFlowStype none");
		}
		
		
	}

	/**
	 * 选择监控的网络类型
	 * 
	 * @param driver
	 * @param network
	 * @throws UiObjectNotFoundException 
	 */
	public void clickNetWork(String network) throws UiObjectNotFoundException {
		if (network.equals("4G")) {
			Ele.getUiObject(By.ID, "com.qihoo360.mobilesafe:id/common_row_title", 0).click();
		} else {
			Ele.getUiObjectByinstance(By.ID, "com.qihoo360.mobilesafe:id/common_row_title", 1).click();
		}
	}

	/**
	 * 点击返回图标
	 * 
	 * @param driver
	 * @throws UiObjectNotFoundException 
	 */
	public void clickBack() throws UiObjectNotFoundException {
		Ele.waitForExistst(
				 By.ID,"com.qihoo360.mobilesafe:id/common_img_back")
				.click();
	}

	/**
	 * 点击设置按钮
	 * 
	 * @param driver
	 * @throws UiObjectNotFoundException 
	 */
	public void clickSetting() throws UiObjectNotFoundException {
		Ele.waitForExistst(
				 By.ID,"com.qihoo360.mobilesafe:id/common_img_setting")
				.click();
	}

	/**
	 * 点击清空流量统计数据
	 * 
	 * @param driver
	 * @throws UiObjectNotFoundException 
	 */
	public void clickClearButton() throws UiObjectNotFoundException {
		Ele.waitForExistst( By.NAME,"清空流量统计数据").click();
		Ele.waitForExistst( By.NAME,"确定").click();
	}

	public String getFlowMessage(String findText) throws UiObjectNotFoundException {
		String strflowtotal = "";
		String flowupdown = "";
		UiObject item = Ele.waitForExistst(By.NAME, findText);
		if (item == null) {
			System.out.println("找不到：" + findText);
			
//			DriverManager.swipeToDown();
		}
		else{
			item.click();
			
			CommonUtil.sleep(2000);
			ImageManager.snapshot("FlowPic_again", "snapshot_again");
		}
//		UiObject flowtotal = driver
//				.findElementByXPath("//android.widget.TextView[contains(@text,'"
//						+ findText
//						+ "')]/following-sibling::android.widget.TextView[1]");
//		
//		UiObject flowtotal = new UiObject(new UiSelector().classNameMatches("139*"));
//		
//		strflowtotal = flowtotal.getText();
//
//		flowtotal.click();
//
//		if (Ele.waitForExistst(By.ID,"com.qihoo360.mobilesafe:id/upload_value") != null) {
//			String up = Ele.waitForExistst(
//					By.ID,"com.qihoo360.mobilesafe:id/upload_value").getText();
//
//			String down = Ele.waitForExistst(
//					 By.ID,"com.qihoo360.mobilesafe:id/load_value").getText();
//
//			flowupdown = up + "#" + down;
//		}
//
//		System.out.println("360卫士记录：" + flowupdown + "，总流量：" +strflowtotal);

		return strflowtotal;
	}

	/**
	 * 关闭360悬浮球
	 * @throws UiObjectNotFoundException 
	 */
	public void closeSuspension() throws UiObjectNotFoundException{
		
		Ele.waitForExistst( By.NAME,"隐私保护").click();
		
		Ele.waitForExistst( By.NAME,"卫士设置").click();
		Ele.waitForExistst( By.NAME,"悬浮窗").click();
		Ele.waitForExistst( By.NAME,"开启内存清理悬浮窗").click();
		
		CommonUtil.adbBack();
		
		CommonUtil.adbBack();
		
		//Ele.waitForExistst( By.id("com.qihoo360.mobilesafe:id/common_img_back")).click();
		
		//Ele.waitForExistst( By.id("com.qihoo360.mobilesafe:id/common_img_back")).click();
		
		Ele.waitForExistst( By.NAME,"常用功能").click();
	}
	
	
}
