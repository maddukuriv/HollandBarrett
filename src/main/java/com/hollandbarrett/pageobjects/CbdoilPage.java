package com.hollandbarrett.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;

public class CbdoilPage extends Action{
	WebDriver driver;
	
	public CbdoilPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// locators
	
	
	public String getCurrentUrl() {
		String favouritesPageUrl = driver.getCurrentUrl();
		return favouritesPageUrl;
	}
	
	
	
}

