package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(2000);
		lp.setUsername(username);
		logger.info("username entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickSubmit();
		logger.info("clicked on submit");
		
		AddCustomerPage acp = new AddCustomerPage(driver);
		Thread.sleep(2000);
		acp.clickAddCustomer();
		logger.info("clicked on add customer");
		
		Thread.sleep(2000);
		acp.setCustomerName("Ishan");
		logger.info("customer name entered");
		Thread.sleep(2000);
		acp.setGender();
		logger.info("gender set");
		Thread.sleep(2000);
		acp.setDate("11", "04","1992");
		logger.info("date added");
		Thread.sleep(2000);
		acp.setAdress("Sonadih cement Plant");
		logger.info("adress set");
		Thread.sleep(2000);
		acp.setCity("raipur");
		logger.info("city added");
		Thread.sleep(2000);
		acp.setSate("Chattisgarh");
		logger.info("state added");
		Thread.sleep(2000);
		String randomPin = randomNumbers();
		acp.setPin(randomPin);
		logger.info("pincode added");
		Thread.sleep(2000);
		acp.setMobile("8055778302");
		logger.info("mobile added");
		Thread.sleep(2000);
		String email = randomString() + "@gmail.com";
		acp.setMail(email);
		logger.info("email entered");
		Thread.sleep(2000);
		acp.setPassword("ishan1234");
		logger.info("password entered");
		Thread.sleep(2000);
		acp.clSubmit();
		logger.info("clicked on submit button");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else {
			Assert.assertTrue(false);
			logger.info("test case failed");
		}
		
	}
}
