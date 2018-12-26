/*
Case Study
----------
Test the edureka portal to throw an exception while registering a user who already 
holds an account with the same email id. Log in to the edureka portal with the 
registered email id,and search for all the courses available and Logout of the edureka 
portal. Write testcases using TestNG for above scenario.
Steps:
1.Launch the Chrome browser
2.Log in to the account and browser for all the courses
3.Logout of the account
4.Use all the concepts learnt in TestNG(dependency, priority, etc)
5.Create another test case to register the user with same email and an exception has to be shown on portal
6.Check for the HTMLreport generated
*/


package casestudy6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CaseStudyTestAlreadyRegisteredEdurekaUser{
	
	WebDriver driver;
	
	@Test
	public void testAlreadyRegisteredEdurekaUser() throws Exception{
	
		//Login into edureka site
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		waitFor(5000);
		driver.findElement(By.xpath("//input[@id='sg_popup_email']")).sendKeys("yasasree09@gmail.com");
		driver.findElement(By.xpath("//input[@id='sg_popup_phone_no']")).sendKeys("9890529927");
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		waitFor(8000);
		
		WebElement errorMessage = driver.findElement(By.xpath("//p[text()='You are registered with us. Login to continue.']"));
		
		if(errorMessage.isDisplayed()) {
			System.out.println("Error thrown as user already exists!!");			
		}		
	}
	
	public void loginWithRegisteredUser(){
		
		//Login into edureka site
				driver.findElement(By.xpath("//a[text()='Log In']")).click();
				waitFor(5000);
				driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys("sreeniyasa@gmail.com");
				driver.findElement(By.xpath("//input[@id='si_popup_passwd']")).sendKeys("**********");
				driver.findElement(By.xpath("//button[text()='Login']")).click();
				waitFor(8000);
	}
	
	@BeforeClass
	private void launchBrowser() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\syasa\\eclipse-workspace\\libs\\geckodriver_15Dec2018.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.edureka.co");
		driver.manage().timeouts().pageLoadTimeout(1200, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	private void waitFor(long waitTime) {

		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	private void closeBrowser() {
		driver.close();
	}

}
