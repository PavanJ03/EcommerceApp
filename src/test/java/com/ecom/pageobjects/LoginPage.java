package com.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']") WebElement txt_emailaddress_loc;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txt_password_loc;
	@FindBy(xpath = "//input[@value='Login']") WebElement btn_login_loc;

	
	public void setEmail(String email) {
		txt_emailaddress_loc.sendKeys(email);
	}
	public void setPassword(String pwd) {
		txt_password_loc.sendKeys(pwd);
	}
	public void clickLogin() {
		btn_login_loc.click();
	}

}
