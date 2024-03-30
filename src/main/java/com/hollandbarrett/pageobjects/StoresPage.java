package com.hollandbarrett.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;

public class StoresPage extends Action {
WebDriver driver;
	
	public StoresPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		//initialization
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getCurrentUrl() {
		String storesPageUrl = driver.getCurrentUrl();
		return storesPageUrl;
		
		
	}

}
