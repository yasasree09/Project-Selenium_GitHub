/*
Case Study
----------

A person wants to check for the one-way flights from Bengaluru to Lucknow for 5 passengers
(3 Adults and 2 children) on Indigo portal for the current date. Automate the same using 
(https://www.goindigo.in/?linkNav=home_header) portal. The steps are as below
.
Steps:

1.Launch the browser with “
https://www.goindigo.in/?linkNav=home_header
”
2.Select “One way” in the option
3.Fill all the details specified above
4.Click on search button
5.Wait for the page to load and list all the flights available
*/


package casestudy4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CaseStudy4FlightTicketAvailabilityCheck {

	WebDriver driver;

	@Test
	public void testFlightTicketAvailabilityCheck() {

		// select source location
		driver.findElement(By.xpath("//input[@name='or-src']")).click();
		waitFor(2000);
		driver.findElement(By.xpath("//input[@name='or-src']")).sendKeys("Bengaluru (BLR)");
		waitFor(2000);
		driver.findElement(By.xpath("//div[@class='airport-code'][text()='BLR']")).click();
		waitFor(2000);

		// select destination
		driver.findElement(By.xpath("//input[@name='or-dest']")).sendKeys("Lucknow (LKO))");
		driver.findElement(By.xpath("//div[@class='airport-code'][text()='LKO']")).click();
		waitFor(2000);

		// click date picker and select the date
		driver.findElement(By.xpath(
				"//td[@class=' selected-date ui-datepicker-current-day']/a[@class='ui-state-default ui-state-active']"))
				.click();
		waitFor(2000);

		// click on passengers text field
		driver.findElement(By.xpath("//input[@name='passenger']")).click();
		waitFor(2000);

		// click to add 3 adult passengers
		driver.findElement(By.xpath(
				"//div[@class='row justify-content-around ie-justify-pass-cur']//li[@class='adult-pax-list']//button[@class='pax-plus btn btn-info']"))
				.click();
		waitFor(2000);
		driver.findElement(By.xpath(
				"//div[@class='row justify-content-around ie-justify-pass-cur']//li[@class='adult-pax-list']//button[@class='pax-plus btn btn-info']//span[@class='icon-plus']"))
				.click();
		waitFor(2000);

		// click to add 2 child passengers
		driver.findElement(By.xpath(
				"//div[@class='row justify-content-around ie-justify-pass-cur']//li[@class='child-pax-list']//button[@class='pax-plus btn btn-info']"))
				.click();
		waitFor(2000);
		driver.findElement(By.xpath(
				"//div[@class='row justify-content-around ie-justify-pass-cur']//li[@class='child-pax-list']//button[@class='pax-plus btn btn-info']"))
				.click();
		waitFor(5000);

		// click on done button
		// driver.findElement(By.xpath("//div[@class='passenger-done-blck']//button[text()='Done']")).click();
		driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[2]/div/button")).click();
		waitFor(3000);

		// click on search flights link
		driver.findElement(By.xpath("//span[text()='Search Flight']")).click();
		waitFor(5000);

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		WebElement allFlights = driver.findElement(By.xpath("//button[contains(text(),'All')]"));
		System.out.println("All flights list :" + allFlights.getText());

	}

	private void waitFor(long waitTime) {

		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	private void launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\syasa\\eclipse-workspace\\libs\\chromedriver_12Dec2018.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.goindigo.in/?linkNav=home_header");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitFor(2000);
	}

	@AfterClass
	private void closeBrowser() {
		driver.close();
	}

}
