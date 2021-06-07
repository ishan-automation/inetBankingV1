package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver){
		driver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(linkText="Log out")
	WebElement clLogout;
	
	//For the above WebElements we have to write action methods
	//We are getting the username and password form actual test case
	public void setUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickLogOut() {
		clLogout.click();
	}
}
