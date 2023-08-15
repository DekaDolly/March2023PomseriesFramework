package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;





public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	//1. By locators -Page locators
	private By emailId=By.id("input-email");
	private By password = By.name("password");
	private By loginBtn=By.xpath("//input[@value='Login']");
	private By forgotPwdLink=By.linkText("Forgotten Password");
			
	//2,Page Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	//3.public page actions/methods
	public String getLoginPageTitle()
	{
		String title=eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		return title;
	}
	public String getLoginPageURL()
	{
		String url=eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION,  AppConstants.SHORT_TIME_OUT);
		System.out.println("Login page URL is::"+url);
		return url;
	}
	public boolean isForgotPwdLinkExist()
	{
		return eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.MEDIUM_TIME_OUT).isDisplayed();
	}
	public String doLogin(String username,String pwd)
	{
		System.out.println("App credare:"+username+":"+pwd);
		eleUtil.waitForElementVisible(emailId, AppConstants.MEDIUM_TIME_OUT).sendKeys(username);;
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		
	}

}
