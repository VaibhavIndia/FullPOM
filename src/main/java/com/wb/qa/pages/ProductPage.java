package com.wb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wb.qa.base.TestBase;

public class ProductPage extends TestBase {
	
	
	ProductPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement usename;
}
