package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	WebDriver driver;
	protected LoginPage loginPage;
	
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		loginPage=new LoginPage(driver);
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
