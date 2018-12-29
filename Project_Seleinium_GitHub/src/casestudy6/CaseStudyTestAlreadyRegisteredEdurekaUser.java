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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CaseStudyTestAlreadyRegisteredEdurekaUser {

	WebDriver driver;

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

	@Test(priority = 0)
	public void testAlreadyRegisteredEdurekaUser() throws Exception {

		// Login into edureka site
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		waitFor(5000);
		driver.findElement(By.xpath("//input[@id='sg_popup_email']")).sendKeys("yasasree09@gmail.com");
		driver.findElement(By.xpath("//input[@id='sg_popup_phone_no']")).sendKeys("9890529927");
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		waitFor(8000);

		WebElement errorMessage = driver
				.findElement(By.xpath("//p[text()='You are registered with us. Login to continue.']"));

		if (errorMessage.isDisplayed()) {
			System.out.println("Error thrown as user already exists!!");
		}
	}

	@Test(priority = 1)
	public void logInUser() {

		// Login into edureka site with existing user
		driver.findElement(By.xpath("//p[contains(text(),'Already have an account?')]//span[text()='Log In']")).click();
		waitFor(5000);
		driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys("yasasree09@gmail.com");
		driver.findElement(By.xpath("//input[@id='si_popup_passwd']")).sendKeys("**********");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		waitFor(8000);
	}

	@Test(priority = 2)
	public void searchAllCourses() {
		// click on All Courses
		driver.findElement(By.xpath("//a[@id='dLabel'][@class='trackHover trackButton']")).click();

		// wait till element is visible
		waitTillElementVisible(10, By.xpath("//h3[contains(text(),'AWS Architect Certification Training')]"));
		waitFor(8000);
	}

	@Test(priority = 3)
	public void logOut() {
		// Logout from edureka site
		driver.findElement(By.xpath("//a[@class='dropdown-toggle trackButton']//img[@class='img30']")).click();
		driver.findElement(By.xpath("//li[@class='dropdown userdrop hidden-sm hidden-xs open']//a[text()='Log Out']"))
				.click();
		waitFor(8000);
	}

	private void waitFor(long waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void waitTillElementVisible(int timeOutInSeconds, By by) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
		Actions action = new Actions(driver);	

	}

	@AfterClass
	private void closeBrowser() {
		driver.close();
	}

}
