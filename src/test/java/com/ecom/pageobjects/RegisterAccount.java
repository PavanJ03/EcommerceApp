package com.ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccount extends BasePage{

	public RegisterAccount(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']") WebElement txt_firstName_loc;
	@FindBy(xpath="//input[@placeholder='Last Name']") WebElement txt_lastName_loc;
	@FindBy(xpath="//input[@placeholder='E-Mail']") WebElement txt_email_loc;
	@FindBy(xpath="//input[@placeholder='Telephone']") WebElement txt_telephone_loc;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txt_password_loc;
	@FindBy(xpath="//input[@placeholder='Password Confirm']") WebElement txt_passwordConfirm_loc;
	@FindBy(xpath="//input[@name='agree']") WebElement chk_agree_loc;
	@FindBy(xpath="//input[@class='btn btn-primary']") WebElement btn_continue_loc;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msg_createdsuccessfully_loc;

	public void setFirstName(String FirstName) {
		txt_firstName_loc.sendKeys(FirstName);
	}
	public void setLastName(String LastName) {
		txt_lastName_loc.sendKeys(LastName);
	}
	public void setEmail(String Email) {
		txt_email_loc.sendKeys(Email);
	}
	public void setTelephone(String Telephone) {
		txt_telephone_loc.sendKeys(Telephone);
	}
	public void setPassword(String Pwd) {
		txt_password_loc.sendKeys(Pwd);
	}
	public void setConfirmPassword(String Pwd) {
		txt_passwordConfirm_loc.sendKeys(Pwd);
	}
	public void chkAgree() {
		chk_agree_loc.click();
	}
	public void clkContinue() {
		btn_continue_loc.click();
	}
	public String getMessage() {
		return msg_createdsuccessfully_loc.getText();
	}

}
