package com.ecom.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browserName) throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
		FileInputStream propfile = new FileInputStream("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(propfile);
		
		switch (browserName.toLowerCase())
		{
		case "chrome" : driver= new ChromeDriver(); break;
		case "edge" : driver= new EdgeDriver(); break;
		case "firefox" : driver= new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name"); return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		logger.info("Application Launched Successfully");
	}
	
	
	/*@AfterClass
	public void tearDown() {
		driver.quit();
	}*/
	
	public String randomString(int num) {
		return RandomStringUtils.randomAlphabetic(num);
	}
	public String randomNumber(int num) {
		return RandomStringUtils.randomNumeric(num);
	}
	public String randomAlphaNumericString(int num) {
		return RandomStringUtils.randomAlphanumeric(num);
	}
	
}
