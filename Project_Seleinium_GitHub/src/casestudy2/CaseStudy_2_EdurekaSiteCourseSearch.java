package casestudy2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaseStudy_2_EdurekaSiteCourseSearch {

	WebDriver driver;
	
	public static void main(String[] args) {
		
		CaseStudy_2_EdurekaSiteCourseSearch casestudy2= new CaseStudy_2_EdurekaSiteCourseSearch();
		casestudy2.searchCourseWithEdurekaSite();
	}
	
	public void searchCourseWithEdurekaSite() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\syasa\\eclipse-workspace\\libs\\chromedriver_12Dec2018.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.edureka.co");
		
		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//search for selenium keyword for selenium courses
		driver.findElement(By.xpath("//input[@class='trackButton']")).sendKeys("Selenium");
		
		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		
		//click on search button
		driver.findElement(By.xpath("//span[@class='search_ico']/i[@id='homeSearchBarIcon']")).click();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//click on selenium course
		driver.findElement(By.xpath("//img[contains(@alt,'Selenium Certification Training ')]")).click();
		
		//Validating the page title
		String pageTitle = driver.getTitle();		
		if(pageTitle.equals("Selenium Online Training & Certification Course- Edureka")) {			
			//assertEquals("Selenium Online Training & Certification Course- Edureka", pageTitle);
			System.out.println("Page title is correct :"+pageTitle);
		}else {
			
			System.out.println("Page title is NOT correct!");
		}
		
		//navigate back to home page
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		
		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		
		//click on All Courses
		driver.findElement(By.xpath("//a[@id='dLabel'][@class='trackHover trackButton']")).click();
		
		//wait till element is visible
		waitTillElementVisible(10, By.xpath("//img[@alt='AWS Architect Certification Training']"));

		//Verify the last course is loaded under all courses
		fluentWait(20, 10, By.xpath("//img[@alt='AWS Architect Certification Training']"));
		WebElement awsCourse = driver.findElement(By.xpath("//img[@alt='AWS Architect Certification Training']"));
		
	}
	
	private void waitTillElementVisible(int timeOutInSeconds, By by) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	private void fluentWait(int timeout, int pollingTime, By by) {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
