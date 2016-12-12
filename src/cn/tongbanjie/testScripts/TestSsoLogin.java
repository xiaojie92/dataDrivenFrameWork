package cn.tongbanjie.testScripts;

import org.testng.annotations.Test;

import cn.tongbanjie.appModules.Login_Action;
import cn.tongbanjie.util.TestAddress;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

/***
 * SSO登录测试脚本
 * 
 * @author xiandao
 *
 */
public class TestSsoLogin {
	public WebDriver driver;
	String baseUrl = TestAddress.baseUrl;

	@Test
	public void TestSsoLogin() throws Exception {
		Login_Action.execute(driver, baseUrl, TestAddress.userName, TestAddress.passWord);
		Assert.assertTrue(driver.getPageSource().contains("Hi,  仙道"));
		Reporter.log("登录功能测试完成！");
	}

	@BeforeMethod
	public void beforeMethod() {
		// DOMConfigurator.configure("log4j.xml");
		// 设定Chrome浏览器启动文件的绝对路径
		System.setProperty("webdriver.chrome.driver", "/Users/sunaojie/Documents/TestWorkPro/Chrome/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}