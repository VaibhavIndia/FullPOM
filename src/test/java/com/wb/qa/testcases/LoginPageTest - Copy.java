package com.wb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wb.qa.base.TestBase;
import com.wb.qa.pages.LoginPage;
import com.wb.qa.pages.ProductPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	ProductPage productpage;
	
    public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageATitleTest()
	{
		String titlepage =  loginpage.getTitle();
		Assert.assertEquals(titlepage,  "Westbrook Motors - Admin Dashboard");
	}
	
	@Test(priority=2)
	public void logoTest()
	{
		 boolean flag = loginpage.validatelogo();
		 Assert.assertTrue(flag); 
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		productpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
}
