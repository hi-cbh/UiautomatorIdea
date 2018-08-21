package com.uitest.uiautomatorUtil;

import java.io.IOException;

public class ADBUtil {


	/**
	 * 休眠时间，毫秒
	 * 1秒 == 1000毫秒
	 * @param times
	 */
	public static void sleep(long times){
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
	}
	/**
	 * 运行命令行
	 * @param cmd
	 */
    public static void cmdLine(String cmd){
    	try {
			Runtime.getRuntime().exec(cmd);
			ADBUtil.sleep(1000);
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
     * @param x
     * @param y
	 *
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
    	
    	ADBUtil.sleep(2000);
    }


	/**
	 * 创建空白文件，用于邮件发送，辅助第三方应用。
	 */
	public static void adbBroadcast() {
		//String path = "";

		//String path = "/mnt/sdcard/Android/data/com.cmcc.test/cache/t.txt";
		ProcessBuilder pb1 = new ProcessBuilder("am", "broadcast", "-a", "cn.cj.pe.LogReceiver"
		);
		try {
			// System.out.print("删除进程");
			pb1.start();
			ADBUtil.sleep(2000);
			 System.out.println("OK!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void adbBroadcastMy() {
		//String path = "";

		ProcessBuilder pb1 = new ProcessBuilder("am", "broadcast", "-a", "myemailbroadcast"
		);
		try {
			// System.out.print("删除进程");
			pb1.start();
			ADBUtil.sleep(2000);
			 System.out.println("OK!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
