package com.mail.mode.ws360;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.mail.pageobject.ws360.WS360PageObject;
import com.uitest.uiautomatorUtil.CommonUtil;
import com.uitest.uiautomatorUtil.ImageManager;

public class FlowRecord360Action {
	public static int timeout = 60;

	/**
	 * 记录流量前，运行360记录流量做准备，预置环境
	 * 
	 * @param 
	 */
	public static void executePreset() {
		try {
			WS360PageObject wp = new WS360PageObject();

			// 获取网络类型
			String network = CommonUtil.getNetworkType();

			// 清理缓存
			CommonUtil.adbClearCache("com.qihoo360.mobilesafe");
			// 启动360卫士
			CommonUtil.adbStartAPP("com.qihoo360.mobilesafe",
					"com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
			// 点击取消
			wp.clickPrivacyButton();

			wp.clickLeftButton();

			wp.closeSuspension();
			
			
			wp.clickBillandFlow();

			wp.clickFlowManager();

			wp.clickGFlow();

			wp.clickNetWork(network);

			wp.clickBack();

			wp.clickSetting();

			wp.clickClearButton();

			wp.clickBack();

			wp.clickBack();

			// 点击Home按键
			CommonUtil.adbHome();
		} catch (Exception e) {
			System.out.println("清空流量失败！！！");
			e.printStackTrace();
		}
	}

	/**
	 * 360卫士记录流量
	 * 
	 * @param 
	 * @param findText
	 *            需要记录的应用名称
	 * @return
	 * @throws UiObjectNotFoundException 
	 */
	public static String executeRecord(String findText) throws UiObjectNotFoundException {
		WS360PageObject wp = new WS360PageObject();
		String strflowtotal = "";

		CommonUtil.adbStartAPP("com.qihoo360.mobilesafe",
				"com.qihoo360.mobilesafe.ui.index.AppEnterActivity");

		wp.clickBillandFlow();

		wp.clickFlowManager();

		strflowtotal = wp.getFlowMessage(findText);

		// 返回到360主界面
		wp.clickBack();

		wp.clickSetting();

		wp.clickClearButton();

		wp.clickBack();

		wp.clickBack();
		return strflowtotal;
	}

	/**
	 * 记录流量值,添加是否截图参数
	 * @param 
	 * @param findText
	 * @param network
	 * @param bl 是否截图，true为截图
	 * @return
	 * @throws UiObjectNotFoundException 
	 */
	public static String executeRecord(String findText,
			String network, boolean bl) throws UiObjectNotFoundException {
		WS360PageObject wp = new WS360PageObject();
		System.out.println("记录360卫士的流量");
		String strflowtotal = "";
		CommonUtil.adbStartAPP("com.qihoo360.mobilesafe",
				"com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
		CommonUtil.sleep(3000);

		wp.clickBillandFlow();
		
		wp.clickFlowManager();
		
		wp.clickFlowStype();
		
		wp.clickNetWork(network);
		
		CommonUtil.sleep(3000);
		
		if(bl){
			ImageManager.snapshot("FlowPic", "flow");
		}
		CommonUtil.sleep(2000);
		
		strflowtotal = wp.getFlowMessage(findText);
		
		wp.clickBack();
		
		wp.clickSetting();

		wp.clickClearButton();
		
		wp.clickBack();

		wp.clickBack();
		
		// 点击Home按键
		CommonUtil.adbHome();
		
		CommonUtil.sleep(3000);
		
		return strflowtotal;
	}

	
	/**
	 * 记录流量值
	 * @param 
	 * @param findText
	 * @param network
	 * @return
	 * @throws UiObjectNotFoundException 
	 */
	public static String executeRecord(String findText,
			String network) throws UiObjectNotFoundException {
		WS360PageObject wp = new WS360PageObject();
		System.out.println("记录360卫士的流量");
		String strflowtotal = "";
		CommonUtil.adbStartAPP("com.qihoo360.mobilesafe",
				"com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
		CommonUtil.sleep(3000);

		wp.clickBillandFlow();
		
		wp.clickFlowManager();
		
		wp.clickFlowStype();
		
		wp.clickNetWork(network);
		
		ImageManager.snapshot("FlowPic", "Flow");

		strflowtotal = wp.getFlowMessage(findText);
		
		wp.clickBack();
		
		wp.clickSetting();

		wp.clickClearButton();
		
		wp.clickBack();

		wp.clickBack();
		
		// 点击Home按键
		CommonUtil.adbHome();
		
		CommonUtil.sleep(3000);
		
		return strflowtotal;
	}

	/**
	 * 记录流量，截图为主
	 * @param 
	 * @param findText
	 * @param network
	 * @return
	 * @throws UiObjectNotFoundException 
	 */
	public static String execute(String network) throws UiObjectNotFoundException {
		WS360PageObject wp = new WS360PageObject();
		System.out.println("记录360卫士的流量");
		String strflowtotal = "";
		CommonUtil.adbStartAPP("com.qihoo360.mobilesafe",
				"com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
		CommonUtil.sleep(3000);

		wp.clickBillandFlow();
		
		wp.clickFlowManager();
		
		wp.clickFlowStype();
		
		wp.clickNetWork( network);
		
		ImageManager.snapshot("FlowPic", "Flow");
		CommonUtil.sleep(5000);
		//strflowtotal = wp.getFlowMessage(, findText);
		
		wp.clickBack();
		
		wp.clickSetting();

		wp.clickClearButton();
		
		wp.clickBack();

		wp.clickBack();
		
		// 点击Home按键
		CommonUtil.adbHome();
		
		CommonUtil.sleep(3000);
		
		return strflowtotal;
	}
	
	
	/**
	 * 清除360卫士的流量
	 * @param 
	 * @throws UiObjectNotFoundException 
	 */
	public static void executeClear() throws UiObjectNotFoundException {
		System.out.println("清除360卫士的流量");
		CommonUtil.sleep(3000);
		// 点击Home按键
		CommonUtil.adbHome();
		CommonUtil
				.adbStartAPP("com.qihoo360.mobilesafe","com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
		
		WS360PageObject wp = new WS360PageObject();
		
		wp.clickBillandFlow();

		wp.clickSetting();

		wp.clickClearButton();
		

		wp.clickBack();

		wp.clickBack();
		

		// 点击Home按键
		CommonUtil.adbHome();
		
		CommonUtil.sleep(3000);
	}

}
