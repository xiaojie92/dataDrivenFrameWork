package cn.tongbanjie.pageObjects;

import org.openqa.selenium.*;

import cn.tongbanjie.util.ObjectMap;

/***
 * 登录页面元素对象
 * 
 * @author xiandao
 *
 */
public class LoginPage {

	private WebElement element = null;
	// 指定页面元素定位表达式配置文件的绝对文件路径
	private ObjectMap objectMap = new ObjectMap(
			"/Users/sunaojie/Documents/TestWorkPro/DataDrivenFrameWork/objectMap.properties");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 返回登录页面中的用户名输入框页面元素对象
	public WebElement userName() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
		element = driver.findElement(objectMap.getLocator("sso.tongbanjie.com.username"));
		return element;
	}

	// 返回登录页面中的密码输入框页面元素对象
	public WebElement password() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于密码的定位方式和定位表达式
		element = driver.findElement(objectMap.getLocator("sso.tongbanjie.com.password"));
		return element;
	}

	// 返回登录页面中的登录按钮页面元素对象
	public WebElement loginButton() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于登录按钮的定位方式和定位表达式
		element = driver.findElement(objectMap.getLocator("sso.tongbanjie.com.loginbutton"));
		return element;
	}
}