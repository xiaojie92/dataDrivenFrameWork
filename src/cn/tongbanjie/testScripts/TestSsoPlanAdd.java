package cn.tongbanjie.testScripts;

import org.testng.annotations.Test;

import cn.tongbanjie.appModules.LoginRaisePlan_Action;
import cn.tongbanjie.util.ExcelUtil;
import cn.tongbanjie.util.TestAddress;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestSsoPlanAdd {
	private WebDriver driver;
	String baseUrl = TestAddress.baseUrl;

	@Test
	public void testAddRaisePlan() throws Exception {
		String name = ExcelUtil.getCellData(1, 1);
		String level1 = ExcelUtil.getCellData(1, 2);
		String level2 = ExcelUtil.getCellData(1, 3);
		String assettype = ExcelUtil.getCellData(1, 4);
		String paybacktype = ExcelUtil.getCellData(1, 5);
		String isreloan = ExcelUtil.getCellData(1, 6);
		String producttype = ExcelUtil.getCellData(1, 7);
		String planamount = ExcelUtil.getCellData(1, 8);
		String period = ExcelUtil.getCellData(1, 9);
		String contractprofit = ExcelUtil.getCellData(1, 10);
		String saleprofit = ExcelUtil.getCellData(1, 11);
		String startbenefitDate = ExcelUtil.getCellData(1, 12);
		String releasetime = ExcelUtil.getCellData(1, 13);
		String merchantperiod = ExcelUtil.getCellData(1, 14);
		String merchantperiodtype = ExcelUtil.getCellData(1, 15);
		String paybackdate = ExcelUtil.getCellData(1, 16);
		String debtortype = ExcelUtil.getCellData(1, 17);
		LoginRaisePlan_Action.execute(driver, baseUrl, TestAddress.userName, TestAddress.passWord, name, level1, level2,
				assettype, paybacktype, isreloan, producttype, planamount, period, contractprofit, saleprofit,
				startbenefitDate, releasetime, merchantperiod, merchantperiodtype, paybackdate, debtortype);
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("新增"));
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/sunaojie/Documents/TestWorkPro/Chrome/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
