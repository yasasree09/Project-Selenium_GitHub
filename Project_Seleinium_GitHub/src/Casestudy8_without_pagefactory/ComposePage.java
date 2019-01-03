package Casestudy8_without_pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComposePage {

	private WebDriver driver;
	
	
	private By toEmailID = By.xpath("//textarea[@id=':oe']");
	private By emailSubject = By.xpath("//input[@name='subjectbox']");
	private By bodyText = By.xpath("//div[@id=':pc']");
	private By sendButton = By.xpath("//div[@id=':nm']");
	
	public ComposePage(WebDriver driver) {		
		this.driver = driver;		
	}
	
	public void toEmailID(String emailId) {
		driver.findElement(toEmailID).sendKeys(emailId);
	}

	public void subject(String subject) {		
		driver.findElement(emailSubject).sendKeys(subject);
	}

	public void body(String body) {		
		driver.findElement(bodyText).sendKeys(body);
	}

	public void send() {
		driver.findElement(sendButton).click();
	}
}
