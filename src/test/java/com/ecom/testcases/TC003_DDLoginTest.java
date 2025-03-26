package com.ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.pageobjects.HomePage;
import com.ecom.pageobjects.LoginPage;
import com.ecom.pageobjects.MyAccount;
import com.ecom.testbase.BaseClass;

import Utilities.DataProviders;

public class TC003_DDLoginTest extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verifyLogin(String email, String password, String usecase) {
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clkMyAccount();
			hp.clkLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			
			MyAccount ma = new MyAccount(driver);
			boolean actmsg = ma.msgHeader();
			
			if(usecase.equalsIgnoreCase("Valid")) {
				if(actmsg==true) {
					ma.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			if(usecase.equalsIgnoreCase("Invalid")) {
				if(actmsg==true) {
					ma.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
				
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail("Test Failed");
		}
			
}
}