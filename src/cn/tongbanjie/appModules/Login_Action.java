package cn.tongbanjie.appModules;

import org.openqa.selenium.WebDriver;

import cn.tongbanjie.pageObjects.LoginPage;

/***
 * SSO登录操作
 * 
 * @author xiandao
 *
 */
public class Login_Action {
	public static void execute(WebDriver driver, String baseUrl, String userName, String passWord) throws Exception {
		driver.get(baseUrl);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userName().sendKeys(userName);
		loginPage.password().sendKeys(passWord);
		loginPage.loginButton().click();
		Thread.sleep(5000);
	}
}