package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
	@Test
	public void loginTest() {
		driver.get(baseURL);
		 logger.info("Url is opened");
		 
		//creating object for Loginpage
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals(" Guru99 Bank Home Page")) {
			Assert.assertTrue(true);
			logger.info("login testcase passed");
		}
		else {
			Assert.assertFalse(false);
			logger.info("login testcase failed");
		}
	}
}
