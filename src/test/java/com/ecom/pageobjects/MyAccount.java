package com.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	public MyAccount(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']") WebElement msgHeading;	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']") WebElement lnkLogout;

	public boolean msgHeader() {
		
		try {
			return msgHeading.isDisplayed();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public void clickLogout() {
		lnkLogout.click();

	}
}
