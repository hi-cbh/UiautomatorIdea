# uiautomator IDEA

标签（空格分隔）： uiautomator

---

# UiautomatorIdea
uiautomator idea上使用

## 适用环境
* android 4.3 - 6.0
* mac / windows环境
* 不支持Xpath，支持ID、Name、ClassName，


# 元素查找

* getUiObject(style,txt) 获取对象
    
```
# 通过资源ID，获取控件并点击
getUiObject(By.ID,"pkg/id").click();

# 通过中文获取控件，并点击 
getUiObject(By.NAME,"中文/英文").click();

```

* getUiObject(style,txt,num) 获取对象列表中的几个，从0开始
通过`index`

```
# 通过资源ID，第0个元素，获取控件并点击
getUiObject(By.ID,"pkg/id",0).click();

# 通过中文，第0个元素，获取控件，并点击 
getUiObject(By.NAME,"中文/英文",0).click();

```

* getUiObject(style,txt,num) 获取对象列表中的几个，从0开始
通过`instance`

```
# 通过资源ID，第0个元素，获取控件并点击
getUiObject(By.ID,"pkg/id",0).click();

# 通过中文，第0个元素，获取控件，并点击 
getUiObject(By.NAME,"中文/英文",0).click();

```

* getUiObject(int style, String text, int style2, String text2, int num) 固定的样式获取对象，获取子集合的对象

```
getUiObject(By.ClLASSNAME, "classname", By.ID, "id", 0)
获取某个classname下的，第0个资源ID为id的控件
```

* waitForExistst(int style, String text, int time) 等待元素出现
```
# 查找页面是否存在控件ID为id，超时返回null
waitForExistst（By.ID,"id",10）

```


* waitUntilGoneById(int style, String text, int time) 等待资源ID消失
```
# 查找页面是否存在控件ID为id，超时返回False
waitUntilGoneById（By.ID,"id",10）

```



##示例

* 获取杀进程启动时间

```
package com.uitest.testdemo;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.donot.change.By;
import com.donot.change.UiAutomatorHelper;
import com.uitest.data.UserConfig;
import com.uitest.uiautomatorUtil.ADBUtil;
import com.uitest.uiautomatorUtil.DriverManager;
import com.uitest.uiautomatorUtil.ElementManager;
import com.uitest.uiautomatorUtil.TimeUtil;

# 创建类必须 extends UiAutomatorTestCase
public class OpenMail  extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "OpenMail";
		String testClass = "com.uitest.testdemo.OpenMail";
		String testName = "";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
	# 创建测试case
    public void testEmail() throws Exception{  

    	String time1 = "";
    	String time2 = "";
    	long valuetime = 0;

    	for(int i = 0; i < 32; i++){
    		System.out.println("tests: " + i);
        	DriverManager.pressHome();
        	# 等待3秒
        	ADBUtil.sleep(3000);

            # 获取桌面的139邮箱，android5.0不识别中文
        	UiObject uo =  ElementManager.waitForExistst(By.NAME, "139邮箱");
        	# 获取当前时间
        	time1 = TimeUtil.getCurrentSysTime();
        	# 点击139
        	uo.click();
            
            #等待页面出现收件箱
        	ElementManager.waitForExistst(By.NAME, "收件箱", 30);
        	# 记录时间
        	time2 = TimeUtil.getCurrentSysTime();
        	# 按HOME键
        	DriverManager.pressHome();
            # 记录时间差
        	valuetime =  TimeUtil.getTimeDistance(time2, time1);

        	System.out.println("alltime:" + (valuetime/1000.0) );

        	ADBUtil.sleep(2000);
        	# 杀进程
        	ADBUtil.adbStopApp("cn.cj.pe");
        	
        	ADBUtil.sleep(2000);
    	}
    } 
}

```
