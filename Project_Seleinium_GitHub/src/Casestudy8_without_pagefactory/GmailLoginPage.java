package Casestudy8_without_pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailLoginPage {

	private WebDriver driver;

	private By emailORphone = By.xpath("//input[@id='identifierId']");
	private By emailPassword = By.xpath("//input[@name='password']");
	private By nextButton = By.xpath("//span[text()='Next']");

	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void emailORPhone(String emailID) {
		driver.findElement(emailORphone).sendKeys(emailID);
	}

	public void password(String password) {
		driver.findElement(emailPassword).sendKeys(password);
	}

	public void nextButton() {
		driver.findElement(nextButton).click();
	}

}
