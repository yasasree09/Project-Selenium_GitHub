package Casestudy8_without_pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailHomePage {

	WebDriver driver;
	
	private By compose = By.className("T-I J-J5-Ji T-I-KE L3");
	private By googleAccount = By.className("gb_cb gbii");
	private By signOut = By.xpath("//a[text()='Sign out']");
	
	public GmailHomePage(WebDriver driver) {		
		this.driver=driver;		
	}
	public void googleAccount() {		
		driver.findElement(googleAccount).click();		
	}	
	
	public void signOut() {		
		driver.findElement(signOut).click();		
	}
	
	public void compose() {		
		driver.findElement(compose).click();		
	}
}
