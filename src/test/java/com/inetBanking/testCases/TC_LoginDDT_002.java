package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002  extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000);
		lp.setUsername(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		logger.info("submit button clicked");
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept(); //close the alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	//user defined method weather to check alert is present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException  e) {
			return false;
		}
	}
	
	

	
	//here we have to provide dataprovider name because test method does'nt know from where to get data
	@DataProvider(name="LoginData") 
	String[][] getData() throws IOException{
		String excelPath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		
		int rownum = 	XLUtils.getRowCount(excelPath, "sheet1");
		int colcount = XLUtils.getCellCount(excelPath, "sheet1", 1);
		
		String loginData[][] = new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				loginData[i-1][j]=XLUtils.getCellData(excelPath,"Sheet1",i,j);
			}
		}
		return loginData;
	}
	
}
