package com.ecom.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@Parameters({"os", "browser"})
	@BeforeClass(groups = {"Master","Regression","Sanity"})
	public void setUp(String os, String browserName) throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
		FileInputStream propfile = new FileInputStream("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(propfile);
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			logger.info("Executing test suite in remote environment");
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching os available....");
				return;
			}
			
			switch(browserName.toLowerCase()) {
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox" : capabilities.setBrowserName("firefox"); break;
			default : System.out.println("No matching browsername available"); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
		
		else if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			logger.info("Executing test suite in local environment");

			switch (browserName.toLowerCase())
			{
			case "chrome" : driver= new ChromeDriver(); break;
			case "edge" : driver= new EdgeDriver(); break;
			case "firefox" : driver= new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name"); return;
			}
		}
		
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		logger.info("Application Launched Successfully");
	}
	
	
	@AfterClass(groups = {"Master","Regression","Sanity"})
	public void tearDown() {
		//driver.close();
		driver.quit();
	}
	
	public String randomString(int num) {
		return RandomStringUtils.randomAlphabetic(num);
	}
	public String randomNumber(int num) {
		return RandomStringUtils.randomNumeric(num);
	}
	public String randomAlphaNumericString(int num) {
		return RandomStringUtils.randomAlphanumeric(num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\FailureSnaps\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
