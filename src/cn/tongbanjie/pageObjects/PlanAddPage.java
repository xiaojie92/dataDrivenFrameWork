package cn.tongbanjie.pageObjects;

import org.openqa.selenium.*;

import cn.tongbanjie.util.ObjectMap;

/***
 * 募集计划新增
 * 
 * @author sunaojie
 *
 */
public class PlanAddPage {
	private WebElement element = null;
	private ObjectMap objectMap = new ObjectMap(
			"/Users/sunaojie/Documents/TestWorkPro/DataDrivenFrameWork/objectMap.properties");
	private WebDriver driver;

	// 获取商户名称输入框
	public WebElement merchantName() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.merchantname"));
		return element;
	}

	// 选择商户名称
	public WebElement choiseName() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.choisename"));
		return element;
	}

	// 查询商户列表
	public WebElement choiseButton() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.choisebutton"));
		return element;
	}

	// 确认商户名称
	public WebElement Cognizance() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.cognizance"));
		return element;
	}

	// 获取一级资产分类
	public WebElement typeLevel1() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.typeLevel1"));
		return element;
	}

	// 获取二级资产分类
	public WebElement typeLevel2() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.typeLevel2"));
		return element;
	}

	// 获取资产分类
	public WebElement assetType() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.assetType"));
		return element;
	}

	// 获取回款方式
	public WebElement paybackType() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.paybackType"));
		return element;
	}

	// 获取是否续贷
	public WebElement isReloan() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.isReloan"));
		return element;
	}

	// 获取产品系列
	public WebElement productType() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.producttype"));
		return element;
	}

	// 获取募集金额（元）
	public WebElement planAmount() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.planAmount"));
		return element;
	}

	// 获取产品期限
	public WebElement period() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.period"));
		return element;
	}

	// 获取合同年化
	public WebElement contractProfit() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.contractProfit"));
		return element;
	}

	// 获取客户年化
	public WebElement saleProfit() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.saleProfit"));
		return element;
	}

	// 获取起息时间
	public WebElement startBenefitDate() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.startBenefitDate"));
		return element;
	}

	// 获取产品预期上线时间
	public WebElement releaseTime() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.releaseTime"));
		return element;
	}

	// 获取商户兑付期限
	public WebElement merchantPeriod() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.merchantPeriod"));
		return element;
	}

	// 获取商户兑付期限单位
	public WebElement merchantPeriodType() throws Exception {
		element = driver.findElement(objectMap.getLocator(""));
		return element;
	}

	// 获取商户还款日
	public WebElement paybackDate() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.paybackDate"));
		return element;
	}

	// 获取贷款类型
	public WebElement debtorType() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.debtorType"));
		return element;
	}

	// 点击保存按钮
	public WebElement saveButton() throws Exception {
		element = driver.findElement(objectMap.getLocator("planaddpage.savebutton"));
		return element;
	}
}