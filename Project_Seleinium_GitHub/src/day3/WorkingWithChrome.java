package day3;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WorkingWithChrome {
	
	ChromeDriver cDriver;
	FirefoxDriver fDriver;
	
@Test
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\syasa\\eclipse-workspace\\libs\\chromedriver_12Dec2018.exe");
		cDriver = new ChromeDriver();
		
		cDriver.manage().window().maximize();
		cDriver.manage().deleteAllCookies();
		cDriver.get("https://www.edureka.co/");
		//cDriver.close();
		
	}
	
	public void invokeFFBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\syasa\\eclipse-workspace\\libs\\geckodriver_15Dec2018.exe");
		fDriver = new FirefoxDriver();
		
		fDriver.manage().window().maximize();
		fDriver.manage().deleteAllCookies();
		fDriver.get("https://www.edureka.co/");
		
		fDriver.close();
	}
	
	public void printTitle() {
		
		System.out.println(cDriver.getTitle());
		
	}
	
	public void closeBrowser() {
		
		cDriver.close();
	}

}
