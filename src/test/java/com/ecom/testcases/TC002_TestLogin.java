package com.ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.pageobjects.HomePage;
import com.ecom.pageobjects.LoginPage;
import com.ecom.pageobjects.MyAccount;
import com.ecom.testbase.BaseClass;

public class TC002_TestLogin extends BaseClass{
	
	@Test(groups = {"Master","Regression","Sanity"})
	public void verifyLogin() {
		try {
			HomePage hp = new HomePage(driver);
			hp.clkMyAccount();
			hp.clkLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();
			
			MyAccount ma = new MyAccount(driver);
			
			if(ma.msgHeader()==true) {
				Assert.assertTrue(true);
				logger.info("Logged in Successfully");
				ma.clickLogout();
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
}
