package day7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonProject {

	WebDriver driver;
	List<WebElement> allLink;

	public void invokeBrowser(String browserType) {

		if (browserType.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\syasa\\eclipse-workspace\\libs\\chromedriver_12Dec2018.exe");
			driver = new ChromeDriver();

		} else if (browserType.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\syasa\\eclipse-workspace\\libs\\geckodriver_15Dec2018.exe");
			driver = new FirefoxDriver();

//		} else if (browserType.equals("edge")) {
//
//			System.setProperty("webdriver.edge.driver",
//					"C:/Users/Saurabh Dhingra/workspace/libs/MicrosoftWebDriver.exe");
//
//			driver = new EdgeDriver();
//
		}

		Dimension dim = new Dimension(768, 1024);

		driver.manage().window().setSize(dim);

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");

	}	
	
	public void searchProduct() {
		
		//select[@class='nav-search-dropdown searchSelect']
		
		
	}

	public void printNthProduct() {
		
		
	}
}
