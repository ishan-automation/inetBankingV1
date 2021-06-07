package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	
	public  AddCustomerPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="New Customer")
	WebElement linkAddCustomer;

	@FindBy(name="name")
	WebElement txtCustomerName;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement radioGender;
	
	@FindBy(id="dob")
	WebElement datePicker;
	
	@FindBy(name="addr")
	WebElement txtAdress;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name="state")
	WebElement txtState;
	
	@FindBy(name="pinno")
	WebElement txtPin;
	
	@FindBy(name="telephoneno")
	WebElement txtMobileNo;
	
	@FindBy(name="emailid")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	
	//Setting the action methods
	
	public void clickAddCustomer() {
		linkAddCustomer.click();
	}
	
	
	public void setCustomerName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void setGender() {
		radioGender.click();
	}
	
	public void setDate(String mm,String dd,String yy) {
		datePicker.sendKeys(mm);
		datePicker.sendKeys(dd);
		datePicker.sendKeys(yy);
	}
	
	public void setAdress(String address) {
		txtAdress.sendKeys(address);
	}
	
	public void setCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void setSate(String state) {
		txtState.sendKeys(state);
	}
	
	public void setPin(String pin) {
		txtPin.sendKeys(pin);
	}
	
	public void setMobile(String mobile) {
		txtMobileNo.sendKeys(mobile);
	}
	
	public void setMail(String mail) {
		txtEmail.sendKeys(mail);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clSubmit() {
		btnSubmit.click();
	}
}
