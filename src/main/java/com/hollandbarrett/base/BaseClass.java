package com.hollandbarrett.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;
	protected String url;
	protected String username;
	protected String password;
	protected String username1;
	protected String password1;
	

	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void setup() throws IOException {
		// load properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/Configuration/GlobalData.properties");
		prop.load(fis);
		
		// read properties
		url = prop.getProperty("url");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        username1 = prop.getProperty("username1");
        password1 = prop.getProperty("password1");
        
     // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
     // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize window on startup
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // Set page load strategy

    
     // Initialize ChromeDriver
        driver = new ChromeDriver(options);

        
     // Maximize the browser window
        driver.manage().window().maximize();
        
     
     // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
     // Set page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
        
        
     // Navigate to the website
        driver.get(url); 
        
	}
	
	@AfterMethod(alwaysRun=true)
	//Method to quit driver
	public void quitDriver() {
    if (driver != null) {
        driver.quit();
        }
    }

}
