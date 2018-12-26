package casestudy1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaseStudyToLaunchEdurekaSite {

	WebDriver driver;
	
	public static void main(String[] args) {
		
		CaseStudyToLaunchEdurekaSite casestudy1 = new CaseStudyToLaunchEdurekaSite();
		casestudy1.invokeBrowser("chrome");
		casestudy1.testEdurekaSiteWithSeleniumMethods();

	}

	public void invokeBrowser(String browserType) {

		if(browserType.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\syasa\\eclipse-workspace\\libs\\chromedriver_12Dec2018.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.edureka.co");
		}
		if(browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\syasa\\eclipse-workspace\\libs\\geckodriver_15Dec2018.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.edureka.co");				
		}
	}

	public void testEdurekaSiteWithSeleniumMethods() {

		//Finding the element using By.id
		System.out.println("Fnding Search Bar element using By.id");	
		WebElement element= driver.findElement(By.id("homeSearchBar"));

		//Finding the element using By.name
		System.out.println("Finding an element By.name");	
		element = driver.findElement(By.name("user_v1[query]"));
		
		//Finding the element using By.className
		System.out.println("Finding an element using By.className");	
		element = driver.findElement(By.className("trackButton"));
		
		//Finding the element using By.xpath
		System.out.println("Finding Search Bar element using By.xpath");	
		element = driver.findElement(By.xpath("//span[@class='search_input']/input[@class='trackButton']"));

		
		//Finding the element using By.cssSelector
		System.out.println("Finding an element using By.cssSelector");	
		element = driver.findElement(By.cssSelector("input[name='user_v1[query]']"));
		
		//Finding the element using By.tagName
		System.out.println("Finding an element using By.tagName");	
		element = driver.findElement(By.tagName("input"));

		//Finding the Login element using By.linkText
		System.out.println("Finding Login element using By.linkText");	
		element = driver.findElement(By.linkText("Log In"));
		
		//Finding the Login element using By.partialLinkText
		System.out.println("Finding Login element using By.partialLinkText");	
		element = driver.findElement(By.partialLinkText("Log"));					
	}

}
