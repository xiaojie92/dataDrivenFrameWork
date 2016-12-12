package cn.tongbanjie.pageObjects;

import org.openqa.selenium.*;

import cn.tongbanjie.util.ObjectMap;

/***
 * 募集计划新增页面
 * 
 * @author sunaojie
 *
 */
public class LoginPlanList {
	private WebElement element = null;
	private ObjectMap objectMap = new ObjectMap(
			"/Users/sunaojie/Documents/TestWorkPro/DataDrivenFrameWork/objectMap.properties");
	private WebDriver driver;

	public LoginPlanList(WebDriver driver) {
		this.driver = driver;
	}

	// 获取登录后loanmng页面
	public WebElement loginLoanmng() throws Exception {
		element = driver.findElement(objectMap.getLocator("sso.loanmng.login"));
		return element;
	}

	// 获取loanmng界面导航
	public WebElement loanmngMng() throws Exception {
		element = driver.findElement(objectMap.getLocator("sso.loanmng.loanmng"));
		return element;
	}

	// 获取募集计划页面
	public WebElement raisePlan() throws Exception {
		element = driver.findElement(objectMap.getLocator("sso.loanmng.raiseplan"));
		return element;
	}

	// 获取募集计划新增页面
	public WebElement addRaiseplan() throws Exception {
		element = driver.findElement(objectMap.getLocator("sso.loanmng.addraiseplan"));
		return element;
	}

	// 进入募集计划新增页面
	public WebElement addPage() throws Exception {
		element = driver.findElement(objectMap.getLocator("sso.raiseplan.addbutton"));
		return element;
	}

}
