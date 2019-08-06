package com.wb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wb.qa.utilities.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		try {
			prop = new Properties();
			FileInputStream fls = new 
					FileInputStream("C:\\Selenium\\Workspace\\CompleteP\\src\\main\\java\\com\\wb\\qa\\config\\config.properties");
			prop.load(fls);
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialize()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://Selenium//Browsers//chrome//chromedriver.exe");
			driver  = new ChromeDriver();
		}
		else if(browserName.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C://Selenium//Browsers//ff//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Please check browser name ..");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
