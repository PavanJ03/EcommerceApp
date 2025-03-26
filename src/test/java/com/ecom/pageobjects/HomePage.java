package com.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//span[normalize-space()='My Account']") WebElement txt_myacct_loc;
	@FindBy(xpath ="//a[normalize-space()='Register']") WebElement txt_register_loc;
	@FindBy(linkText = "Login") WebElement btn_linkLogin_loc;
	
	public void clkMyAccount() {
		txt_myacct_loc.click();
	}
	public void clkRegister() {
		txt_register_loc.click();
	}
	public void clkLogin()    // added in step5
	{
		btn_linkLogin_loc.click();
	}
}
