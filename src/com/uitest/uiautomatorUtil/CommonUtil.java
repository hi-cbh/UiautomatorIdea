package com.uitest.uiautomatorUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CommonUtil {


	/**
	 * 判断WiFi是否开启
	 * 
	 * @return
	 */
	public static boolean adbGetWifi_on() {
		ProcessBuilder pb1 = new ProcessBuilder("settings",
				"get", "global", "wifi_on");
		StringBuffer result = new StringBuffer();
		boolean wifi_on = false;
		try {
			Process process = pb1.start();
			Scanner scanner = new Scanner(process.getInputStream());
			while (scanner.hasNextLine()) {
				result.append(scanner.nextLine());
			}
			scanner.close();
			if (!result.toString().contains("0")) {// 0 代表关闭
				wifi_on = true;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return wifi_on;
	}
	
	/**
	 * 读取手机网络
	 * 
	 * @return
	 */
	public static String getNetworkType() {
		boolean result = adbGetWifi_on();
		String type = "CMCC";
		if (!result) {
			type = "4G";
		}
		return type;
	}
	
	
	/**
	 * 休眠时间，毫秒
	 * @param times
	 */
	public static void sleep(long times){
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 运行命令行
	 * @param cmd
	 */
    public static void cmdLine(String cmd){
    	try {
			Runtime.getRuntime().exec(cmd);
			CommonUtil.sleep(1000);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	
    /**
     * 杀进程
     * @param pkg
     */
    public static void adbStopApp(String pkg){
    	cmdLine("am force-stop " + pkg);
    }
    
    /**
     * 点击屏幕
     * @param pkg
     */
    public static void tap(int x, int y){
    	cmdLine("input tap " + x + " " + y);
    }
    
    
    /**
     * 清除缓存
     * @param pkg
     */
    public static void adbClearCache(String pkg){
    	cmdLine("pm clear " + pkg);
    }
    
    
    /**
     * 启动App
     * @param pkg
     * @param activity
     */
    public static void adbStartAPP(String pkg, String activity){
    	cmdLine("am start -n " + pkg+"/"+activity);
    }
    
    /**
     * 点击返回
     */
    public static void adbBack(){
    	cmdLine("input keyevent 4");
    }
    
    /**
     * 点击Home
     */
    public static void adbHome(){
    	cmdLine("input keyevent 3");
    	
    	CommonUtil.sleep(2000);
    }
    public static String getPID(String PackageName) {

		Process proc = null;
		String PID = "";
		try {
			Runtime runtime = Runtime.getRuntime();
			proc = runtime.exec("adb shell ps | findStr  " + PackageName);

			if (proc.waitFor() != 0) {
				System.err.println("exit value = " + proc.exitValue());
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			while ((line = in.readLine()) != null) {
				stringBuffer.append(line + " ");

			}
			String str1 = stringBuffer.toString().trim();
			String[] s = str1.split("\\s+"); // 以空格分隔

			PID = s[1];
			//System.out.println("PID:" + PID);
			PID = PID.trim();

			return PID;
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				proc.destroy();
			} catch (Exception e2) {
			}
		}

		return PID;
	}

}
