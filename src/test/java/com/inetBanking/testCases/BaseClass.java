package com.inetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationUrl();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	//taking parameters from xml file
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath() );
			driver = new ChromeDriver();
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver=new FirefoxDriver();
		}else {
			System.out.println("Enter valid browser name");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		//setting up the log4j file
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	//generating random string and numbers because email should unique here
		public String randomString() {
			String generatedString= RandomStringUtils.randomAlphabetic(5); //will return 5 characters in the string
			return generatedString;
		}
		
		public String randomNumbers() {
			String generatedString2= RandomStringUtils.randomNumeric(6); //will return 4 characters in the number
			return generatedString2;
		}
}
