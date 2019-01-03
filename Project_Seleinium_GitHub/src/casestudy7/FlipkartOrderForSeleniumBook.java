/*
Case Study
----------

A student needs to shop for a Selenium book using Flipkart website and the book has to be delivered 
to the student’s area.Since he does not own a valid credentials, he is unable to place the order. Automate 
the same using selenium java. Upon failure the screen shot has to be captured and retry again. Implement all the listeners in TestNG to understand better.

Steps:
1.
Open browser with Flipkart website
2.Search for a Selenium book
3.Check if it is delivered to the pin code specified and print the duration needed
4. Add to the cart 
5.While checking out, give a random email id and password 
6.Capture the error message and capture the screen shot

*/


package casestudy7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartOrderForSeleniumBook {

	WebDriver driver;

	@BeforeClass
	public void lanuchBrowser() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\syasa\\eclipse-workspace\\libs\\geckodriver_15Dec2018.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(75, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");

	}

	@Test(priority = 0)
	public void orderBookInFlipkart() throws InterruptedException {

		// close login window if exists
		Thread.sleep(2000);
		WebElement loginWindow = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		if (loginWindow.isDisplayed()) {

			driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		}
		// type for selenium book
		driver.findElement(By.xpath("//input[@class='LM6RPg']"))
				.sendKeys("selenium webdriver 1st edition rajeev gupta");
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		driver.findElement(By.xpath("//a[@class='Zhf2z-']")).click();
		Thread.sleep(1000);

		// stitch to new tab
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		// driver.close();
		// driver.switchTo().window(tabs2.get(0));

		// check delivery date by entering pin code and print it
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='_3X4tVa']")).sendKeys("411014");
		driver.findElement(By.xpath("//span[@class='_2aK_gu']")).click();
		String deliveredBy = driver.findElement(By.xpath("//div[@class='_29Zp1s']")).getText();
		String deliveredDate = driver.findElement(By.xpath("//span[@class='_3nCwDW']")).getText();
		System.out.println("Delivery date :" + deliveredBy + " - " + deliveredDate);

		// click on go to cart
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
		Thread.sleep(2000);

		// click on place order
		driver.findElement(By.xpath("//button[@class='_2AkmmA _14O7kc _7UHT_c']")).click();
		Thread.sleep(2000);

		// enter dummy email id
		driver.findElement(By.xpath("//input[@class='_2zrpKA _14H79F']")).sendKeys("MyNameEmailID");
		driver.findElement(By.xpath("//span[text()='CONTINUE']")).click();
		Thread.sleep(1000);

	}

	@Test(priority = 1)
	public void screenShot() throws IOException {

		// capture the screen shot for an error
		TakesScreenshot screenShot = ((TakesScreenshot) driver);
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\screenshots\\error_message.png");
		FileUtils.copyFile(srcFile, destFile);
	}

	@AfterClass
	public void closeBrowser() {

		driver.close();
	}

}

