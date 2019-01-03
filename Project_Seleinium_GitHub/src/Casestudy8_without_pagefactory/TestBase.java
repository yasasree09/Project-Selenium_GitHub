package Casestudy8_without_pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	
	WebDriver driver;
	
	public TestBase(WebDriver driver) {
		this.driver = driver;			
	}
    public void testIntilize(String webSite) {    	
     	
    	System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\syasa\\eclipse-workspace\\libs\\geckodriver_15Dec2018.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(75, TimeUnit.SECONDS);
		//webSite.trim(); 
		driver.get(webSite);
    }
    public void closeBrowser() {
    	
    	driver.quit();
    }
    
    public void waitFor(long waitTime) {

		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}    
}
