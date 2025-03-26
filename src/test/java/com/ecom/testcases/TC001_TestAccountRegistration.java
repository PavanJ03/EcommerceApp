package com.ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.pageobjects.HomePage;
import com.ecom.pageobjects.RegisterAccount;
import com.ecom.testbase.BaseClass;

public class TC001_TestAccountRegistration extends BaseClass{

	@Test
	void verify_Acct_Registration() {
		
		logger.info("****   Home Page is displayed    ****");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clkMyAccount();
			hp.clkRegister();
			
			RegisterAccount ra = new RegisterAccount(driver);
			ra.setFirstName(randomString(5));
			ra.setLastName(randomString(4));
			ra.setEmail(randomString(6)+"@gmail.com");
			ra.setTelephone(randomNumber(10));
			String pwd = randomAlphaNumericString(13);
			System.out.println(pwd);
			ra.setPassword(pwd);
			ra.setConfirmPassword(pwd);
			ra.chkAgree();
			ra.clkContinue();
			
			Assert.assertEquals(ra.getMessage(), "Your Account Has Been Created!");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("****   Exception has thrown. Test failed    ****");
			Assert.fail();
		}
		
	}

	
	
}
