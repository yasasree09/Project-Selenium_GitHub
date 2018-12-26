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


package casestudy5;

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

public class CaseStudyToUpdateEdurekaUserProfile {
	
	WebDriver driver;
	
	@Test
	public void updateEdurekaUserProfile() {
	
		//Login into edureka site
		driver.findElement(By.xpath("//a[text()='Log In']")).click();
		waitFor(5000);
		driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys("sreeniyasa@gmail.com");
		driver.findElement(By.xpath("//input[@id='si_popup_passwd']")).sendKeys("**********");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		waitFor(8000);
		
		//click on My Profile 
		driver.findElement(By.xpath("//a[@class='dropdown-toggle trackButton']//img[@class='img30']")).click();
		driver.findElement(By.xpath("//li[@class='dropdown userdrop hidden-sm hidden-xs open']//a[text()='My Profile']")).click();
		waitFor(8000);
		
		//update the personal details
		driver.findElement(By.xpath("//div[@class='personal-details']//a[@class='profile-edit-icon']")).click();
		waitFor(9000);
		driver.findElement(By.name("fullname")).clear();
		driver.findElement(By.name("fullname")).sendKeys("Sreeni Yasa");
		driver.findElement(By.name("currentrole")).clear();
		driver.findElement(By.name("currentrole")).sendKeys("QA Technical Consultant");
		driver.findElement(By.name("phone_number")).clear();
		driver.findElement(By.name("phone_number")).sendKeys("9890529927");
		
		//select the experience from drop down list
		WebElement experinceDropdown = driver.findElement(By.xpath("//select[@id='experience']"));
		Select clickOnDrown = new Select(experinceDropdown);
		clickOnDrown.selectByVisibleText(">15 years");
		
		//disbaled the below code as it requires validation of OTP
		
		//driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div/form/button")).click();
		//waitFor(500);
		//driver.findElement(By.xpath("//button[text()='Verify & Continue']")).click();
		//waitFor(5000);

		//update professional details
		driver.findElement(By.xpath("//li[@class='onboarding-tabs professional-details-tab']//a[@href='/onboarding/professionaldetails']")).click();
		waitFor(5000);
		driver.findElement(By.name("companyName")).clear();
		driver.findElement(By.name("companyName")).sendKeys("PTC Software (India) Pvt Ltd");
	
		WebElement currentJobDropdown = driver.findElement(By.name("currentjob"));
		Select selectDropdown = new Select(currentJobDropdown);
		selectDropdown.selectByVisibleText("Mid Management");
		
		WebElement currentIndustryDropdown = driver.findElement(By.name("currentIndustry"));
		Select selectCurrentIndustryDropdown = new Select(currentIndustryDropdown);
		selectCurrentIndustryDropdown.selectByVisibleText("IT-Software / Software Services");
		
		driver.findElement(By.name("userSkill")).clear();
		driver.findElement(By.name("userSkill")).sendKeys("Manual & Automation testing, Java,Selenium,API testing");
		
		driver.findElement(By.name("linkedinLink")).clear();
		driver.findElement(By.name("linkedinLink")).sendKeys("https://www.linkedin.com/in/sreeni-yasa-49137614/?originalSubdomain=nz");
		
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		waitFor(1000);
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

//	@AfterClass
//	private void closeBrowser() {
//		driver.close();
//	}

}
