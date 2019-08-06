package com.wb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wb.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement usename;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loinbtn;
	
	@FindBy(xpath = "//a[text()='Forgot Password?']")
	WebElement forgotpassword_link;
	
	@FindBy(xpath="//div[@class='text-center']/span/img")
	WebElement logo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}

	
	public ProductPage login(String uname,String pwd)
	{
		usename.sendKeys(uname);
		password.sendKeys(pwd);
		loinbtn.click();
		
		return new ProductPage();
	}
	
	public boolean validatelogo()
	{
		 return logo.isDisplayed();
	}
	
}
