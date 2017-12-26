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


}
