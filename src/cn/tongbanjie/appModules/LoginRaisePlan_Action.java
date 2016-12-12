package cn.tongbanjie.appModules;

import org.openqa.selenium.*;
import org.testng.Assert;

import cn.tongbanjie.pageObjects.LoginPlanList;
import cn.tongbanjie.pageObjects.PlanAddPage;

/***
 * 募集计划新增页面复用操作
 * 
 * @author sunaojie
 *
 */
public class LoginRaisePlan_Action {
	public static void execute(WebDriver driver, String baseUrl, String userName, String passWord, String name,
			String level1, String level2, String assettype, String paybacktype, String isreloan, String producttype,
			String planamount, String period, String contractprofit, String saleprofit, String startbenefitDate,
			String releasetime, String merchantperiod, String merchantperiodtype, String paybackdate, String debtortype)
			throws Exception {
		Login_Action.execute(driver, baseUrl, userName, passWord);
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains("Hi,  仙道"));
		LoginPlanList loginPlanList = new LoginPlanList(driver);
		loginPlanList.loginLoanmng().click();
		Thread.sleep(3000);
		loginPlanList.loanmngMng().click();
		Thread.sleep(3000);
		loginPlanList.raisePlan().click();
		Thread.sleep(3000);
		loginPlanList.addRaiseplan().click();
		Thread.sleep(3000);
		loginPlanList.addPage().click();
		Thread.sleep(3000);
		PlanAddPage planAddPage = new PlanAddPage();
		planAddPage.merchantName().click();
		planAddPage.choiseName().sendKeys(name);
		planAddPage.choiseButton().click();
		planAddPage.Cognizance().click();
		planAddPage.typeLevel1().sendKeys(level1);
		planAddPage.typeLevel2().sendKeys(level2);
		planAddPage.assetType().sendKeys(assettype);
		planAddPage.paybackType().sendKeys(paybacktype);
		planAddPage.isReloan().sendKeys(isreloan);
		planAddPage.productType().sendKeys(producttype);
		planAddPage.planAmount().sendKeys(planamount);
		planAddPage.period().sendKeys(period);
		planAddPage.contractProfit().sendKeys(contractprofit);
		planAddPage.saleProfit().sendKeys(saleprofit);
		planAddPage.startBenefitDate().sendKeys(startbenefitDate);
		planAddPage.releaseTime().sendKeys(releasetime);
		planAddPage.merchantPeriod().sendKeys(merchantperiod);
		planAddPage.merchantPeriodType().sendKeys(merchantperiodtype);
		planAddPage.paybackDate().sendKeys(paybackdate);
		planAddPage.debtorType().sendKeys(debtortype);
		planAddPage.saveButton().click();
		Thread.sleep(3000);
	}
}
